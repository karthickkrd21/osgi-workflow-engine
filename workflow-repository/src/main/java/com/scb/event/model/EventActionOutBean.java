package com.scb.event.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.scb.event.model.id.EventActionOutBeanKey;

@Entity
@Table(name = "EVENT_ACTION_OUT_BEAN")
public class EventActionOutBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private EventActionOutBeanKey eventActionOutBeanKey;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ACTION_ID", insertable = false, updatable = false)
	private EventAction eventAction;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "BEAN_ID", insertable = false, updatable = false)
	private EventBean eventBean;

	@Column(name = "BEAN_SEQUENCE", length = 10)
	private Integer beanSequence;

	public EventAction getEventAction() {
		return eventAction;
	}

	public void setEventAction(EventAction eventAction) {
		this.eventAction = eventAction;
	}

	public EventBean getEventBean() {
		return eventBean;
	}

	public void setEventBean(EventBean eventBean) {
		this.eventBean = eventBean;
	}

	public Integer getBeanSequence() {
		return beanSequence;
	}

	public void setBeanSequence(Integer beanSequence) {
		this.beanSequence = beanSequence;
	}

	public EventActionOutBeanKey getEventActionOutBeanKey() {
		return eventActionOutBeanKey;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((beanSequence == null) ? 0 : beanSequence.hashCode());
		result = prime * result
				+ ((eventAction == null) ? 0 : eventAction.hashCode());
		result = prime
				* result
				+ ((eventActionOutBeanKey == null) ? 0 : eventActionOutBeanKey
						.hashCode());
		result = prime * result
				+ ((eventBean == null) ? 0 : eventBean.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EventActionOutBean other = (EventActionOutBean) obj;
		if (beanSequence == null) {
			if (other.beanSequence != null)
				return false;
		} else if (!beanSequence.equals(other.beanSequence))
			return false;
		if (eventAction == null) {
			if (other.eventAction != null)
				return false;
		} else if (!eventAction.equals(other.eventAction))
			return false;
		if (eventActionOutBeanKey == null) {
			if (other.eventActionOutBeanKey != null)
				return false;
		} else if (!eventActionOutBeanKey.equals(other.eventActionOutBeanKey))
			return false;
		if (eventBean == null) {
			if (other.eventBean != null)
				return false;
		} else if (!eventBean.equals(other.eventBean))
			return false;
		return true;
	}
	
	

}
