package com.scb.event.model.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class EventActionOutBeanKey implements Serializable{

	private static final long serialVersionUID = -9092725550257620795L;

	@Column(name = "ACTION_ID", nullable = false)
	private String actionId;

	@Column(name = "BEAN_ID", nullable = false)
	private String beanId;

	public String getActionId() {
		return actionId;
	}

	public void setActionId(String actionId) {
		this.actionId = actionId;
	}

	public String getBeanId() {
		return beanId;
	}

	public void setBeanId(String beanId) {
		this.beanId = beanId;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((actionId == null) ? 0 : actionId.hashCode());
		result = prime * result
				+ ((beanId == null) ? 0 : beanId.hashCode());
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
		EventActionOutBeanKey other = (EventActionOutBeanKey) obj;
		if (actionId == null) {
			if (other.actionId != null)
				return false;
		} else if (!actionId.equals(other.actionId))
			return false;
		if (beanId == null) {
			if (other.beanId != null)
				return false;
		} else if (!beanId.equals(other.beanId))
			return false;
		return true;
	}
	
	

}
