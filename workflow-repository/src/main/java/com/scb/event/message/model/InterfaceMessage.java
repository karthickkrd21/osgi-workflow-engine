package com.scb.event.message.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.apache.commons.lang.builder.HashCodeBuilder;

@Entity
@Table(name = "INT_MESSAGE")
public class InterfaceMessage implements Serializable {

	private static final long serialVersionUID = -4303955287853182824L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "INT_MSG_SEQ")
	@SequenceGenerator(name = "INT_MSG_SEQ", sequenceName = "EVENT_MESSAGE_SEQ")
	@Column(name = "INT_MSG_ID")
	private BigDecimal id;

	@Column(name = "MESSAGE_TYPE", length = 120)
	private String messageType;

	@Column(name = "MESSAGE_SUB_TYPE", length = 120)
	private String messageSubType;

	@Column(name = "MESSAGE_SENDER", length = 120)
	private String messageSender;

	@Column(name = "MESSAGE_TIMESTAMP")
	private Date messageTimestamp;

	@Column(name = "INITIATED_TIMESTAMP")
	private Date initiatedTimestamp;

	@Column(name = "TRACKING_ID", length = 120)
	private String trackingId;

	@Column(name = "CORRELATION_ID", length = 120)
	private String correlationId;

	@Column(name = "CONVERSATION_ID", length = 120)
	private String conversationId;

	@Column(name = "CAPTURE_SYSTEM", length = 120)
	private String captureSystem;

	@Column(name = "PROCESS_NAME", length = 120)
	private String processName;

	@Column(name = "EVENT_TYPE", length = 120)
	private String eventType;

	@Column(name = "ACTION", length = 120)
	private String action;

	@Column(name = "PAYLOAD")
	@Lob
	private String payload;

	@Column(name = "CREATED_ON")
	private Date createdOn;

	@Column(name = "UPDATED_ON")
	private Date updatedOn;

	@Column(name = "CREATED_BY", length = 120)
	private String createdBy;

	@Column(name = "UPDATED_BY", length = 120)
	private String updatedBy;

	@Column(name = "ERROR_DESC", length = 4000)
	private String errorDescription;

	@Column(name = "IS_POSSIBLE_DUPLICATE")
	private Boolean possibleDuplicate;

	@Column(name = "STATUS", length = 20)
	@Enumerated(EnumType.STRING)
	private InterfaceMessageStatus status;

	public static enum InterfaceMessageStatus {
		PENDING, PROCESSED, FAILED;
	}

	/**
	 * @return the id
	 */
	public BigDecimal getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(final BigDecimal id) {
		this.id = id;
	}

	/**
	 * @return the messageType
	 */
	public String getMessageType() {
		return messageType;
	}

	/**
	 * @param messageType
	 *            the messageType to set
	 */
	public void setMessageType(final String messageType) {
		this.messageType = messageType;
	}

	/**
	 * @return the messageSubType
	 */
	public String getMessageSubType() {
		return messageSubType;
	}

	/**
	 * @param messageSubType
	 *            the messageSubType to set
	 */
	public void setMessageSubType(final String messageSubType) {
		this.messageSubType = messageSubType;
	}

	/**
	 * @return the messageSender
	 */
	public String getMessageSender() {
		return messageSender;
	}

	/**
	 * @param messageSender
	 *            the messageSender to set
	 */
	public void setMessageSender(final String messageSender) {
		this.messageSender = messageSender;
	}

	/**
	 * @return the messageTimestamp
	 */
	public Date getMessageTimestamp() {
		return messageTimestamp;
	}

	/**
	 * @param messageTimestamp
	 *            the messageTimestamp to set
	 */
	public void setMessageTimestamp(final Date messageTimestamp) {
		this.messageTimestamp = messageTimestamp;
	}

	/**
	 * @return the initiatedTimestamp
	 */
	public Date getInitiatedTimestamp() {
		return initiatedTimestamp;
	}

	/**
	 * @param initiatedTimestamp
	 *            the initiatedTimestamp to set
	 */
	public void setInitiatedTimestamp(final Date initiatedTimestamp) {
		this.initiatedTimestamp = initiatedTimestamp;
	}

	/**
	 * @return the trackingId
	 */
	public String getTrackingId() {
		return trackingId;
	}

	/**
	 * @param trackingId
	 *            the trackingId to set
	 */
	public void setTrackingId(final String trackingId) {
		this.trackingId = trackingId;
	}

	/**
	 * @return the correlationId
	 */
	public String getCorrelationId() {
		return correlationId;
	}

	/**
	 * @param correlationId
	 *            the correlationId to set
	 */
	public void setCorrelationId(final String correlationId) {
		this.correlationId = correlationId;
	}

	/**
	 * @return the conversationId
	 */
	public String getConversationId() {
		return conversationId;
	}

	/**
	 * @param conversationId
	 *            the conversationId to set
	 */
	public void setConversationId(final String conversationId) {
		this.conversationId = conversationId;
	}

	/**
	 * @return the captureSystem
	 */
	public String getCaptureSystem() {
		return captureSystem;
	}

	/**
	 * @param captureSystem
	 *            the captureSystem to set
	 */
	public void setCaptureSystem(final String captureSystem) {
		this.captureSystem = captureSystem;
	}

	/**
	 * @return the processName
	 */
	public String getProcessName() {
		return processName;
	}

	/**
	 * @param processName
	 *            the processName to set
	 */
	public void setProcessName(final String processName) {
		this.processName = processName;
	}

	/**
	 * @return the eventType
	 */
	public String getEventType() {
		return eventType;
	}

	/**
	 * @param eventType
	 *            the eventType to set
	 */
	public void setEventType(final String eventType) {
		this.eventType = eventType;
	}

	/**
	 * @return the action
	 */
	public String getAction() {
		return action;
	}

	/**
	 * @param action
	 *            the action to set
	 */
	public void setAction(final String action) {
		this.action = action;
	}

	/**
	 * @return the payload
	 */
	public String getPayload() {
		return payload;
	}

	/**
	 * @param payload
	 *            the payload to set
	 */
	public void setPayload(final String payload) {
		this.payload = payload;
	}

	/**
	 * @return the createdOn
	 */
	public Date getCreatedOn() {
		return createdOn;
	}

	/**
	 * @param createdOn
	 *            the createdOn to set
	 */
	public void setCreatedOn(final Date createdOn) {
		this.createdOn = createdOn;
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
	 * @return the createdBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy
	 *            the createdBy to set
	 */
	public void setCreatedBy(final String createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * @return the updatedBy
	 */
	public String getUpdatedBy() {
		return updatedBy;
	}

	/**
	 * @param updatedBy
	 *            the updatedBy to set
	 */
	public void setUpdatedBy(final String updatedBy) {
		this.updatedBy = updatedBy;
	}

	/**
	 * @return the errorDescription
	 */
	public String getErrorDescription() {
		return errorDescription;
	}

	/**
	 * @param errorDescription
	 *            the errorDescription to set
	 */
	public void setErrorDescription(final String errorDescription) {
		this.errorDescription = errorDescription;
	}

	/**
	 * @return the status
	 */
	public InterfaceMessageStatus getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(final InterfaceMessageStatus status) {
		this.status = status;
	}

	/**
	 * @return the possibleDuplicate
	 */
	public Boolean getPossibleDuplicate() {
		return possibleDuplicate;
	}

	/**
	 * @param possibleDuplicate
	 *            the possibleDuplicate to set
	 */
	public void setPossibleDuplicate(final Boolean possibleDuplicate) {
		this.possibleDuplicate = possibleDuplicate;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append("id").append("messageType").append("messageSubType")
				.append("messageSender").append("messageTimestamp").append("initiatedTimestamp").append("trackingId")
				.append("correlationId").append("conversationId").append("captureSystem").append("processName")
				.append("eventType").append("action").append("payload").append("createdOn").append("updatedOn")
				.append("createdBy").append("updatedBy").append("errorDescription").append("possibleDuplicate")
				.append("status").toHashCode();
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final InterfaceMessage other = (InterfaceMessage) obj;
		if (action == null) {
			if (other.action != null)
				return false;
		} else if (!action.equals(other.action))
			return false;
		if (captureSystem == null) {
			if (other.captureSystem != null)
				return false;
		} else if (!captureSystem.equals(other.captureSystem))
			return false;
		if (conversationId == null) {
			if (other.conversationId != null)
				return false;
		} else if (!conversationId.equals(other.conversationId))
			return false;
		if (correlationId == null) {
			if (other.correlationId != null)
				return false;
		} else if (!correlationId.equals(other.correlationId))
			return false;
		if (createdBy == null) {
			if (other.createdBy != null)
				return false;
		} else if (!createdBy.equals(other.createdBy))
			return false;
		if (createdOn == null) {
			if (other.createdOn != null)
				return false;
		} else if (!createdOn.equals(other.createdOn))
			return false;
		if (errorDescription == null) {
			if (other.errorDescription != null)
				return false;
		} else if (!errorDescription.equals(other.errorDescription))
			return false;
		if (eventType == null) {
			if (other.eventType != null)
				return false;
		} else if (!eventType.equals(other.eventType))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (initiatedTimestamp == null) {
			if (other.initiatedTimestamp != null)
				return false;
		} else if (!initiatedTimestamp.equals(other.initiatedTimestamp))
			return false;
		if (messageSender == null) {
			if (other.messageSender != null)
				return false;
		} else if (!messageSender.equals(other.messageSender))
			return false;
		if (messageSubType == null) {
			if (other.messageSubType != null)
				return false;
		} else if (!messageSubType.equals(other.messageSubType))
			return false;
		if (messageTimestamp == null) {
			if (other.messageTimestamp != null)
				return false;
		} else if (!messageTimestamp.equals(other.messageTimestamp))
			return false;
		if (messageType == null) {
			if (other.messageType != null)
				return false;
		} else if (!messageType.equals(other.messageType))
			return false;
		if (payload == null) {
			if (other.payload != null)
				return false;
		} else if (!payload.equals(other.payload))
			return false;
		if (possibleDuplicate == null) {
			if (other.possibleDuplicate != null)
				return false;
		} else if (!possibleDuplicate.equals(other.possibleDuplicate))
			return false;
		if (processName == null) {
			if (other.processName != null)
				return false;
		} else if (!processName.equals(other.processName))
			return false;
		if (status != other.status)
			return false;
		if (trackingId == null) {
			if (other.trackingId != null)
				return false;
		} else if (!trackingId.equals(other.trackingId))
			return false;
		if (updatedBy == null) {
			if (other.updatedBy != null)
				return false;
		} else if (!updatedBy.equals(other.updatedBy))
			return false;
		if (updatedOn == null) {
			if (other.updatedOn != null)
				return false;
		} else if (!updatedOn.equals(other.updatedOn))
			return false;
		return true;
	}

}