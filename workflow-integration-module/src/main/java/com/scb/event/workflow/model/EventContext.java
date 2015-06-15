package com.scb.event.workflow.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.scb.event.message.model.EventMessage;
import com.scb.event.message.model.EventMessageFork;
import com.scb.event.message.model.ExecutionStatus;
import com.scb.event.model.EventFlow;

public class EventContext implements Serializable {

	/** Default SerialVersionUID */
	private static final long serialVersionUID = 1L;

	private ProcessContext processContext = new ProcessContext();
	private EventFlow eventFlow;
	private EventMessage eventMessage;
	private EventMessage previousMessage;
	private EventMessage originalMessage;
	private ExecutionStatus executionStatus;
	private Throwable error;
	private List<EventMessageFork> messageForks = new ArrayList<EventMessageFork>();

	/**
	 * @return the processContext
	 */
	public ProcessContext getProcessContext() {
		return processContext;
	}

	/**
	 * @param processContext
	 *            the processContext to set
	 */
	public void setProcessContext(ProcessContext processContext) {
		this.processContext = processContext;
	}

	/**
	 * @return the eventFlow
	 */
	public EventFlow getEventFlow() {
		return eventFlow;
	}

	/**
	 * @param eventFlow
	 *            the eventFlow to set
	 */
	public void setEventFlow(EventFlow eventFlow) {
		this.eventFlow = eventFlow;
	}

	/**
	 * @return the eventMessage
	 */
	public EventMessage getEventMessage() {
		return eventMessage;
	}

	/**
	 * @param eventMessage
	 *            the eventMessage to set
	 */
	public void setEventMessage(EventMessage eventMessage) {
		this.eventMessage = eventMessage;
	}

	/**
	 * @return the executionStatus
	 */
	public ExecutionStatus getExecutionStatus() {
		return executionStatus;
	}

	/**
	 * @param executionStatus
	 *            the executionStatus to set
	 */
	public void setExecutionStatus(ExecutionStatus executionStatus) {
		this.executionStatus = executionStatus;
	}

	/**
	 * @return the messageForks
	 */
	public List<EventMessageFork> getMessageForks() {
		return messageForks;
	}

	/**
	 * @param messageForks
	 *            the messageForks to set
	 */
	public void setMessageForks(List<EventMessageFork> messageForks) {
		this.messageForks = messageForks;
	}

	/**
	 * @return the previousMessage
	 */
	public EventMessage getPreviousMessage() {
		return previousMessage;
	}

	/**
	 * @param previousMessage
	 *            the previousMessage to set
	 */
	public void setPreviousMessage(EventMessage previousMessage) {
		this.previousMessage = previousMessage;
	}

	/**
	 * @return the originalMessage
	 */
	public EventMessage getOriginalMessage() {
		return originalMessage;
	}

	/**
	 * @param originalMessage
	 *            the originalMessage to set
	 */
	public void setOriginalMessage(EventMessage originalMessage) {
		this.originalMessage = originalMessage;
	}

	/**
	 * @return the error
	 */
	public Throwable getError() {
		return error;
	}

	/**
	 * @param error
	 *            the error to set
	 */
	public void setError(Throwable error) {
		this.error = error;
	}

}
