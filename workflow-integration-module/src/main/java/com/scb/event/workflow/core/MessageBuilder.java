package com.scb.event.workflow.core;

import java.util.Calendar;

import com.scb.event.message.model.EventMessage;
import com.scb.event.message.repository.MessageRepository;
import com.scb.event.workflow.model.EventContext;
import com.scb.event.workflow.model.ProcessContext;

public class MessageBuilder {

	private MessageRepository messageRepository;

	public MessageRepository getMessageRepository() {
		return messageRepository;
	}

	public void setMessageRepository(final MessageRepository messageRepository) {
		this.messageRepository = messageRepository;
	}

	public EventContext getEventContext(final ProcessContext processContext) {
		final EventContext context = new EventContext();
		context.setProcessContext(processContext);
		return context;
	}

	public EventMessage buildEventMessage(final EventContext context) {
		System.out.println("Inside the Message Builder BuildEventMessage");
		final EventMessage message = new EventMessage();
		if (context.getEventFlow() != null && context.getEventFlow().getTargetNode() != null) {
			// TODO Need to change the incrementor
			System.out.println("Inside the save of Event Message");
			message.setApplicationGroup(context.getProcessContext().getApplicationGroup());
			message.setAction(context.getEventFlow().getAction());
			message.setCountry(context.getProcessContext().getCountry());
			message.setCreatedOn(Calendar.getInstance().getTime());
			message.setCreatedBy(context.getProcessContext().getUserId());
			message.setInstance(context.getProcessContext().getInstanceCode());
			message.setEntity(context.getProcessContext().getEntity());
			if (context.getEventMessage() != null) {
				message.setPreviousMessage(context.getEventMessage());
				if (context.getPreviousMessage() != null) {
					message.setOriginalMessage(context.getPreviousMessage());
				}
			}
			this.messageRepository.save(message);
		}
		context.setEventMessage(message);
		return message;
	}
}
