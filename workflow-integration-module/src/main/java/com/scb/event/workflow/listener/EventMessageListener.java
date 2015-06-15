package com.scb.event.workflow.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.scb.event.message.model.EventMessage;
import com.scb.event.message.model.EventMessageFork;
import com.scb.event.message.repository.MessageForkRepository;
import com.scb.event.message.repository.MessageRepository;
import com.scb.event.workflow.core.EventInvocator;
import com.scb.event.workflow.model.EventContext;
import com.scb.event.workflow.model.ProcessContext;
import com.scb.event.workflow.util.DefaultErrorHandler;
import com.scb.event.workflow.util.JacksonPayloadProcessor;

public class EventMessageListener implements MessageListener {

	private static final Logger logger = LoggerFactory.getLogger(EventMessageListener.class);

	private EventInvocator eventInvocator;

	private MessageRepository messageRepository;

	private MessageForkRepository messageForkRepository;

	private JacksonPayloadProcessor jacksonPayloadProcessor;

	private DefaultErrorHandler errorHandler;

	public void setErrorHandler(final DefaultErrorHandler errorHandler) {
		this.errorHandler = errorHandler;
	}

	@Override
	public void onMessage(final Message message) {
		try {
			if (message instanceof ObjectMessage) {
				EventMessageFork messageFork = null;
				final Object payload = ((ObjectMessage) message).getObject();
				if (payload instanceof EventMessageFork) {
					messageFork = (EventMessageFork) payload;
					final EventContext context = getEventContext(messageFork);
					eventInvocator.invoke(context, jacksonPayloadProcessor.deserialize(messageFork));
					messageFork.setExecutionStatus(context.getExecutionStatus());
					messageFork.setError(errorHandler.handleError(context));
					this.messageForkRepository.save(messageFork);
				} else {
					logger.info("Incompatible Payload Types could not be processed {}", payload.getClass().getName());
				}
			}
		} catch (final JMSException e) {
			logger.error("Message could not be processed", e);
		} catch (final ClassNotFoundException e) {
			logger.error("ClassNotFoundException: ", e);
		}
	}

	private EventContext getEventContext(final EventMessageFork messageFork) throws ClassNotFoundException {
		final EventContext context = new EventContext();
		EventMessage message;
		message = this.messageRepository.fetch(messageFork.getEventMessage().getMessageId());
		messageFork.setEventMessage(message);
		context.getProcessContext().setApplicationGroup(message.getApplicationGroup());
		context.setEventFlow(messageFork.getEventFlow());
		context.getProcessContext().setUserId(message.getCreatedBy());
		context.setEventMessage(messageFork.getEventMessage());
		if (context.getEventMessage() != null)
			context.getEventMessage().setPayload(message.getPayload());
		context.setProcessContext(getProcessContext(messageFork));
		context.setPreviousMessage(message.getPreviousMessage());
		context.setOriginalMessage(message.getOriginalMessage());
		return context;
	}

	private ProcessContext getProcessContext(final EventMessageFork messageFork) {
		final ProcessContext context = new ProcessContext();
		context.setFlowId(messageFork.getEventFlow().getId());
		context.setActionId(messageFork.getEventFlow().getAction().getId());
		context.setChunkProcessingEnabled(messageFork.getEventFlow().getChunkProcessingEnabled());
		return context;
	}

	public EventInvocator getEventInvocator() {
		return eventInvocator;
	}

	public void setEventInvocator(final EventInvocator eventInvocator) {
		this.eventInvocator = eventInvocator;
	}

	public MessageRepository getMessageRepository() {
		return messageRepository;
	}

	public void setMessageRepository(final MessageRepository messageRepository) {
		this.messageRepository = messageRepository;
	}

	public MessageForkRepository getMessageForkRepository() {
		return messageForkRepository;
	}

	public void setMessageForkRepository(final MessageForkRepository messageForkRepository) {
		this.messageForkRepository = messageForkRepository;
	}

	public JacksonPayloadProcessor getJacksonPayloadProcessor() {
		return jacksonPayloadProcessor;
	}

	public void setJacksonPayloadProcessor(final JacksonPayloadProcessor jacksonPayloadProcessor) {
		this.jacksonPayloadProcessor = jacksonPayloadProcessor;
	}

	public DefaultErrorHandler getErrorHandler() {
		return errorHandler;
	}

}