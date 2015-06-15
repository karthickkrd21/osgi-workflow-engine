package com.scb.event.workflow.core;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.beanutils.PropertyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import com.scb.event.message.model.EventMessageAttribute;
import com.scb.event.message.model.EventMessageFork;
import com.scb.event.message.model.ExecutionStatus;
import com.scb.event.message.model.MessageType;
import com.scb.event.message.repository.MessageAttributeRepository;
import com.scb.event.message.repository.MessageForkRepository;
import com.scb.event.message.repository.MessageRepository;
import com.scb.event.model.EventBean;
import com.scb.event.model.EventBeanAttribute;
import com.scb.event.model.EventFlow;
import com.scb.event.model.FlowCategory;
import com.scb.event.repository.BeanConfigurationRepository;
import com.scb.event.repository.ConfigurationRepository;
import com.scb.event.repository.RetryConfigurationRepository;
import com.scb.event.workflow.model.EventContext;
import com.scb.event.workflow.model.ProcessContext;
import com.scb.event.workflow.publisher.EventMessagePublisher;
import com.scb.event.workflow.util.JacksonPayloadProcessor;
import com.scb.wb.transaction.annotation.TransactionalContext;

public class EventInvocatorImpl implements EventInvocator {

	private final Logger logger = LoggerFactory.getLogger(EventInvocatorImpl.class);

	private ConfigurationRepository configurationRepository;

	private BeanConfigurationRepository beanConfigurationRepository;

	private MessageRepository messageRepository;

	private MessageBuilder messageBuilder;

	private MessageAttributeRepository messageAttributeRepository;

	private MessageForkRepository messageForkRepository;

	private EventMessagePublisher eventMessagePublisher;

	private EventProcessor processor;

	private JacksonPayloadProcessor jacksonPayloadProcessor;

	private RetryConfigurationRepository retryConfigurationRepository;

	@Override
	@SuppressWarnings("unchecked")
	@TransactionalContext
	public <T, S> S invoke(final ProcessContext processContext, final T payload) {
		System.out.println("Entering the invoke method of Event Invocator");
		S response = null;
		final EventContext context = messageBuilder.getEventContext(processContext);
		context.setEventFlow(configurationRepository.findByFlowId(processContext.getFlowId()));
		response = (S) invoke(context, payload);
		return response;
	}

	private void publishForks(final EventContext context) {
		if (context.getMessageForks() != null) {
			for (final EventMessageFork fork : context.getMessageForks()) {
				try {
					eventMessagePublisher.publish(fork);
				} catch (final Exception e) {
					logger.error("Message could not be published due to errors", e);
					fork.setLocked(false);
					fork.setExecutionStatus(ExecutionStatus.RETRY);
					fork.setUpdatedOn(Calendar.getInstance().getTime());
					this.messageForkRepository.save(fork);
				}
			}
		}

	}

	@Override
	@SuppressWarnings("unchecked")
	public <T, S> S invoke(final EventContext context, final T payload) {
		System.out.println("Entering the invoke method of Event Context2");
		messageBuilder.buildEventMessage(context);
		S response = null;
		try {
			response = (S) processor.execute(context, payload);
			context.setExecutionStatus(ExecutionStatus.SUCCESS);
		} catch (final Exception e) {
			final Iterable<String> retryExceptions = retryConfigurationRepository.findByFlowId(context.getEventFlow()
					.getId());
			if (retryExceptions != null
					&& (CollectionUtils.contains(retryExceptions.iterator(), e.getClass().getCanonicalName()) || CollectionUtils
							.contains(retryExceptions.iterator(), e.getClass().getSimpleName()))) {
				context.setExecutionStatus(ExecutionStatus.RETRY);
			} else {
				context.setExecutionStatus(ExecutionStatus.ERROR);
				context.setError(e);
			}
		}

		if (ExecutionStatus.SUCCESS == context.getExecutionStatus() && context.getEventFlow().getTargetNode() != null) {
			final Iterable<EventFlow> targetFlows = this.configurationRepository.findBySourceNodeId(context
					.getEventFlow().getTargetNode().getId());
			if (targetFlows != null) {
				for (final EventFlow targetFlow : targetFlows) {
					createNewFork(targetFlow, context);
				}
				this.messageForkRepository.save(context.getMessageForks());
			}
			createNextNodeMessage(context, response);
		}
		publishForks(context);
		return response;
	}

	private void createNewFork(final EventFlow targetFlow, final EventContext context) {
		final EventMessageFork messageFork = new EventMessageFork();
		messageFork.setEventFlow(targetFlow);
		messageFork.setEventMessage(context.getEventMessage());
		messageFork.getEventMessageForkKey().setFlowId(targetFlow.getId());
		messageFork.getEventMessageForkKey().setMessageId(context.getEventMessage().getMessageId());
		messageFork.setUpdatedOn(Calendar.getInstance().getTime());
		messageFork.setError("Sample Error");
		if (FlowCategory.BATCH == targetFlow.getFlowCategory()) {
			messageFork.setExecutionStatus(ExecutionStatus.PENDING);
		} else {
			messageFork.setExecutionStatus(null);
		}
		messageFork.setRetryCount(0);
		context.getMessageForks().add(messageFork);
	}

	private <T> void createNextNodeMessage(final EventContext context, final T payload) {
		final Set<EventMessageAttribute> messageAttributes = new HashSet<EventMessageAttribute>();
		if (context.getEventMessage() != null) {
			context.getEventMessage().setPublished(false);
			context.getEventMessage().setNode(context.getEventFlow().getTargetNode());
			context.getEventMessage().setPayload(jacksonPayloadProcessor.serialize(payload));
			context.getEventMessage().setPayloadType(MessageType.OBJECT);
			context.getEventMessage().setPayloadSubType(payload.getClass().getName());
			final EventBean bean = beanConfigurationRepository.findByBeanClass(payload.getClass().getName());
			if (bean != null && bean.getAttributes() != null) {
				for (final EventBeanAttribute beanAttribute : bean.getAttributes()) {
					messageAttributes.add(getMessageAttribute(context, payload, beanAttribute));
				}
				this.messageAttributeRepository.save(messageAttributes);
			}
			this.messageRepository.save(context.getEventMessage());
		}
	}

	private <T> EventMessageAttribute getMessageAttribute(final EventContext context, final T payload,
			final EventBeanAttribute beanAttribute) {
		final EventMessageAttribute messageAttribute = new EventMessageAttribute();
		messageAttribute.setAttributeKey(beanAttribute);
		messageAttribute.setEventMessage(context.getEventMessage());
		messageAttribute.getEventMessageAttributeKey().setAttributeId(
				beanAttribute.getEventBeanAttributeKey().getAttributeId());
		messageAttribute.getEventMessageAttributeKey().setBeanId(beanAttribute.getEventBean().getId());
		messageAttribute.getEventMessageAttributeKey().setMessageId(context.getEventMessage().getMessageId());
		try {
			messageAttribute.setAttributeValue(PropertyUtils.getProperty(payload, beanAttribute.getBeanAttribute())
					.toString());
		} catch (final Exception e) {
			logger.error("Could not access specified attribute in the Payload", e);
		}
		return messageAttribute;
	}

	public ConfigurationRepository getConfigurationRepository() {
		return configurationRepository;
	}

	public void setConfigurationRepository(final ConfigurationRepository configurationRepository) {
		this.configurationRepository = configurationRepository;
	}

	public BeanConfigurationRepository getBeanConfigurationRepository() {
		return beanConfigurationRepository;
	}

	public void setBeanConfigurationRepository(final BeanConfigurationRepository beanConfigurationRepository) {
		this.beanConfigurationRepository = beanConfigurationRepository;
	}

	public MessageRepository getMessageRepository() {
		return messageRepository;
	}

	public void setMessageRepository(final MessageRepository messageRepository) {
		this.messageRepository = messageRepository;
	}

	public MessageBuilder getMessageBuilder() {
		return messageBuilder;
	}

	public void setMessageBuilder(final MessageBuilder messageBuilder) {
		this.messageBuilder = messageBuilder;
	}

	public MessageAttributeRepository getMessageAttributeRepository() {
		return messageAttributeRepository;
	}

	public void setMessageAttributeRepository(final MessageAttributeRepository messageAttributeRepository) {
		this.messageAttributeRepository = messageAttributeRepository;
	}

	public MessageForkRepository getMessageForkRepository() {
		return messageForkRepository;
	}

	public void setMessageForkRepository(final MessageForkRepository messageForkRepository) {
		this.messageForkRepository = messageForkRepository;
	}

	public EventMessagePublisher getEventMessagePublisher() {
		return eventMessagePublisher;
	}

	public void setEventMessagePublisher(final EventMessagePublisher eventMessagePublisher) {
		this.eventMessagePublisher = eventMessagePublisher;
	}

	public EventProcessor getProcessor() {
		return processor;
	}

	public void setProcessor(final EventProcessor processor) {
		this.processor = processor;
	}

	public JacksonPayloadProcessor getJacksonPayloadProcessor() {
		return jacksonPayloadProcessor;
	}

	public void setJacksonPayloadProcessor(final JacksonPayloadProcessor jacksonPayloadProcessor) {
		this.jacksonPayloadProcessor = jacksonPayloadProcessor;
	}

	public RetryConfigurationRepository getRetryConfigurationRepository() {
		return retryConfigurationRepository;
	}

	public void setRetryConfigurationRepository(final RetryConfigurationRepository retryConfigurationRepository) {
		this.retryConfigurationRepository = retryConfigurationRepository;
	}

}
