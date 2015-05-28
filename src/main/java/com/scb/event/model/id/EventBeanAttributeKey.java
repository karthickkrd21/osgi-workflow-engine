package com.scb.event.model.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class EventBeanAttributeKey implements Serializable{

	private static final long serialVersionUID = 8863679207086425440L;

	@Column(name = "BEAN_ID", length = 120)
	private String beanId;

	@Column(name = "ATTRIBUTE_ID", length = 512)
	private String attributeId;

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

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((attributeId == null) ? 0 : attributeId.hashCode());
		result = prime * result + ((beanId == null) ? 0 : beanId.hashCode());
		return result;
	}

	/* (non-Javadoc)
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
		EventBeanAttributeKey other = (EventBeanAttributeKey) obj;
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
		return true;
	}
	
	
}
