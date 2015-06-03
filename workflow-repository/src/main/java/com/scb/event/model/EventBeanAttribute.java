package com.scb.event.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.scb.event.model.id.EventBeanAttributeKey;

@Entity
@Table(name = "EVENT_BEAN_ATTRIBUTE")
public class EventBeanAttribute implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private EventBeanAttributeKey eventBeanAttributeKey;

	@ManyToOne
	@JoinColumn(name = "BEAN_ID", insertable = false, updatable = false)
	private EventBean eventBean;

	@Column(name = "BEAN_ATTRIBUTE", length = 1024)
	private String beanAttribute;

	/**
	 * @return the eventBean
	 */
	public EventBean getEventBean() {
		return eventBean;
	}

	/**
	 * @param eventBean
	 *            the eventBean to set
	 */
	public void setEventBean(final EventBean eventBean) {
		this.eventBean = eventBean;
	}

	/**
	 * @return the beanAttribute
	 */
	public String getBeanAttribute() {
		return beanAttribute;
	}

	/**
	 * @param beanAttribute
	 *            the beanAttribute to set
	 */
	public void setBeanAttribute(final String beanAttribute) {
		this.beanAttribute = beanAttribute;
	}

	public EventBeanAttributeKey getEventBeanAttributeKey() {
		return eventBeanAttributeKey;
	}

	public void setEventBeanAttributeKey(final EventBeanAttributeKey eventBeanAttributeKey) {
		this.eventBeanAttributeKey = eventBeanAttributeKey;
	}

	@Override
	public int hashCode() {
		return 0;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final EventBeanAttribute other = (EventBeanAttribute) obj;
		if (beanAttribute == null) {
			if (other.beanAttribute != null)
				return false;
		} else if (!beanAttribute.equals(other.beanAttribute))
			return false;
		if (eventBean == null) {
			if (other.eventBean != null)
				return false;
		} else if (!eventBean.equals(other.eventBean))
			return false;
		if (eventBeanAttributeKey == null) {
			if (other.eventBeanAttributeKey != null)
				return false;
		} else if (!eventBeanAttributeKey.equals(other.eventBeanAttributeKey))
			return false;
		return true;
	}

}