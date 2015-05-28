package com.scb.event.message.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.apache.commons.lang.builder.HashCodeBuilder;

import com.scb.event.message.model.id.EventMessageForkKey;
import com.scb.event.model.EventFlow;

@Entity
@NamedQuery(name = EventMessageFork.FIND_BY_EXECUTION_STATUS, query = "select c from EventMessageFork c where c.executionStatus=:executionStatus")
@Table(name = "EVENT_MESSAGE_FORK")
public class EventMessageFork implements Serializable {

	private static final long serialVersionUID = -6944555643334421546L;

	public static final String FIND_BY_EXECUTION_STATUS = "EventMessageFork_FindByExecutionStatus";
	@EmbeddedId
	private EventMessageForkKey eventMessageForkKey;

	@OneToOne
	@JoinColumn(name = "FLOW_ID", insertable = false, updatable = false)
	private EventFlow eventFlow;

	@OneToOne
	@JoinColumn(name = "MESSAGE_ID", insertable = false, updatable = false)
	private EventMessage eventMessage;

	@Column(name = "EXECUTION_STATUS")
	@Enumerated(EnumType.STRING)
	private ExecutionStatus executionStatus;

	@Column(name = "ERROR")
	@Lob
	private String error;

	@Column(name = "RETRY_COUNT")
	private Integer retryCount;

	@Column(name = "IS_LOCKED")
	private Boolean locked;

	@Column(name = "DATE_UPDATED")
	private Date updatedOn;

	public EventMessageFork() {
		this.eventMessageForkKey = new EventMessageForkKey();
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
	public void setEventFlow(final EventFlow eventFlow) {
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
	public void setEventMessage(final EventMessage eventMessage) {
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
	public void setExecutionStatus(final ExecutionStatus executionStatus) {
		this.executionStatus = executionStatus;
	}

	/**
	 * @return the retryCount
	 */
	public Integer getRetryCount() {
		return retryCount;
	}

	/**
	 * @param retryCount
	 *            the retryCount to set
	 */
	public void setRetryCount(final Integer retryCount) {
		this.retryCount = retryCount;
	}

	/**
	 * @return the locked
	 */
	public Boolean getLocked() {
		return locked;
	}

	/**
	 * @param locked
	 *            the locked to set
	 */
	public void setLocked(final Boolean locked) {
		this.locked = locked;
	}

	/**
	 * @return the updatedOn
	 */
	public Date getUpdatedOn() {
		return updatedOn;
	}

	/**
	 * @param updatedOn
	 *            the updatedOn to set
	 */
	public void setUpdatedOn(final Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	/**
	 * @return the eventMessageForkKey
	 */
	public EventMessageForkKey getEventMessageForkKey() {
		return eventMessageForkKey;
	}

	/**
	 * @param eventMessageForkKey
	 *            the eventMessageForkKey to set
	 */
	public void setEventMessageForkKey(final EventMessageForkKey eventMessageForkKey) {
		this.eventMessageForkKey = eventMessageForkKey;
	}

	/**
	 * @return the error
	 */
	public String getError() {
		return error;
	}

	/**
	 * @param error
	 *            the error to set
	 */
	public void setError(final String error) {
		this.error = error;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append("eventMessageForkKey").append("executionStatus").append("error")
				.append("retryCount").append("locked").append("updatedOn").toHashCode();
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final EventMessageFork other = (EventMessageFork) obj;
		if (error == null) {
			if (other.error != null)
				return false;
		} else if (!error.equals(other.error))
			return false;
		if (eventFlow == null) {
			if (other.eventFlow != null)
				return false;
		} else if (!eventFlow.equals(other.eventFlow))
			return false;
		if (eventMessage == null) {
			if (other.eventMessage != null)
				return false;
		} else if (!eventMessage.equals(other.eventMessage))
			return false;
		if (eventMessageForkKey == null) {
			if (other.eventMessageForkKey != null)
				return false;
		} else if (!eventMessageForkKey.equals(other.eventMessageForkKey))
			return false;
		if (executionStatus != other.executionStatus)
			return false;
		if (locked == null) {
			if (other.locked != null)
				return false;
		} else if (!locked.equals(other.locked))
			return false;
		if (retryCount == null) {
			if (other.retryCount != null)
				return false;
		} else if (!retryCount.equals(other.retryCount))
			return false;
		if (updatedOn == null) {
			if (other.updatedOn != null)
				return false;
		} else if (!updatedOn.equals(other.updatedOn))
			return false;
		return true;
	}

}
