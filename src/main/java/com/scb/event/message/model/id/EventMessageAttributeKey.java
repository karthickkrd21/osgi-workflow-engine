package com.scb.event.message.model.id;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class EventMessageAttributeKey implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "MESSAGE_ID", precision = 38, scale = 0)
	private BigDecimal messageId;

	@Column(name = "BEAN_ID")
	private String beanId;

	@Column(name = "ATTRIBUTE_ID")
	private String attributeId;

	/**
	 * @return the messageId
	 */
	public BigDecimal getMessageId() {
		return messageId;
	}

	/**
	 * @param messageId
	 *            the messageId to set
	 */
	public void setMessageId(BigDecimal messageId) {
		this.messageId = messageId;
	}

	/**
	 * @return the beanId
	 */
	public String getBeanId() {
		return beanId;
	}

	/**
	 * @param beanId
	 *            the beanId to set
	 */
	public void setBeanId(String beanId) {
		this.beanId = beanId;
	}

	/**
	 * @return the attributeId
	 */
	public String getAttributeId() {
		return attributeId;
	}

	/**
	 * @param attributeId
	 *            the attributeId to set
	 */
	public void setAttributeId(String attributeId) {
		this.attributeId = attributeId;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((attributeId == null) ? 0 : attributeId.hashCode());
		result = prime * result + ((beanId == null) ? 0 : beanId.hashCode());
		result = prime * result + ((messageId == null) ? 0 : messageId.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EventMessageAttributeKey other = (EventMessageAttributeKey) obj;
		if (attributeId == null) {
			if (other.attributeId != null)
				return false;
		} else if (!attributeId.equals(other.attributeId))
			return false;
		if (beanId == null) {
			if (other.beanId != null)
				return false;
		} else if (!beanId.equals(other.beanId))
			return false;
		if (messageId == null) {
			if (other.messageId != null)
				return false;
		} else if (!messageId.equals(other.messageId))
			return false;
		return true;
	}

}
