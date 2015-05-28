package com.scb.event.message.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.lang.builder.HashCodeBuilder;

import com.scb.event.message.model.id.EventMessageAttributeKey;
import com.scb.event.model.EventBeanAttribute;

@Entity
@Table(name = "EVENT_MESSAGE_ATTRIBUTE")
public class EventMessageAttribute implements Serializable {

	private static final long serialVersionUID = -546114812557085905L;

	@EmbeddedId
	private EventMessageAttributeKey eventMessageAttributeKey;

	@ManyToOne
	@JoinColumn(name = "MESSAGE_ID", insertable = false, updatable = false)
	private EventMessage eventMessage;

	@Column(name = "BEAN_SEQUENCE")
	private Integer sequence;

	@ManyToOne
	@JoinColumns({
			@JoinColumn(name = "BEAN_ID", referencedColumnName = "BEAN_ID", insertable = false, updatable = false),
			@JoinColumn(name = "ATTRIBUTE_ID", referencedColumnName = "ATTRIBUTE_ID", insertable = false, updatable = false) })
	private EventBeanAttribute attributeKey;

	@Column(name = "ATTRIBUTE_VALUE")
	private String attributeValue;

	public EventMessageAttribute() {
		this.eventMessageAttributeKey = new EventMessageAttributeKey();
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
	 * @return the sequence
	 */
	public Integer getSequence() {
		return sequence;
	}

	/**
	 * @param sequence
	 *            the sequence to set
	 */
	public void setSequence(final Integer sequence) {
		this.sequence = sequence;
	}

	/**
	 * @return the attributeKey
	 */
	public EventBeanAttribute getAttributeKey() {
		return attributeKey;
	}

	/**
	 * @param attributeKey
	 *            the attributeKey to set
	 */
	public void setAttributeKey(final EventBeanAttribute attributeKey) {
		this.attributeKey = attributeKey;
	}

	/**
	 * @return the attributeValue
	 */
	public String getAttributeValue() {
		return attributeValue;
	}

	/**
	 * @param attributeValue
	 *            the attributeValue to set
	 */
	public void setAttributeValue(final String attributeValue) {
		this.attributeValue = attributeValue;
	}

	/**
	 * @return the eventMessageAttributeKey
	 */
	public EventMessageAttributeKey getEventMessageAttributeKey() {
		return eventMessageAttributeKey;
	}

	/**
	 * @param eventMessageAttributeKey
	 *            the eventMessageAttributeKey to set
	 */
	public void setEventMessageAttributeKey(final EventMessageAttributeKey eventMessageAttributeKey) {
		this.eventMessageAttributeKey = eventMessageAttributeKey;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append("eventMessageAttributeKey").append("sequence").append("attributeValue")
				.toHashCode();
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final EventMessageAttribute other = (EventMessageAttribute) obj;
		if (attributeKey == null) {
			if (other.attributeKey != null)
				return false;
		} else if (!attributeKey.equals(other.attributeKey))
			return false;
		if (attributeValue == null) {
			if (other.attributeValue != null)
				return false;
		} else if (!attributeValue.equals(other.attributeValue))
			return false;
		if (eventMessage == null) {
			if (other.eventMessage != null)
				return false;
		} else if (!eventMessage.equals(other.eventMessage))
			return false;
		if (eventMessageAttributeKey == null) {
			if (other.eventMessageAttributeKey != null)
				return false;
		} else if (!eventMessageAttributeKey.equals(other.eventMessageAttributeKey))
			return false;
		if (sequence == null) {
			if (other.sequence != null)
				return false;
		} else if (!sequence.equals(other.sequence))
			return false;
		return true;
	}

}
