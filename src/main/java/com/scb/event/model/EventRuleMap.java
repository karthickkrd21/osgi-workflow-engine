package com.scb.event.model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.apache.commons.lang.builder.HashCodeBuilder;

import com.scb.event.model.id.EventRuleMapKey;

@Entity
@Table(name = "EVENT_RULE_MAP")
@NamedQuery(name = EventRuleMap.EVENT_RULE_MAP_FIND_BY_FLOW_ID, query = "select c from EventRuleMap c left join fetch c.eventBean left join fetch c.eventRule left join fetch c.eventFlow where c.key.flowId=:flowId ")
public class EventRuleMap implements Serializable {

	private static final long serialVersionUID = -5009198018527700963L;

	public static final String EVENT_RULE_MAP_FIND_BY_FLOW_ID = "EventRuleMap.findByFlowId";

	@EmbeddedId
	private EventRuleMapKey key;

	@OneToOne
	@JoinColumn(name = "RULE_ID", insertable = false, updatable = false)
	private EventRule eventRule;

	@OneToOne
	@JoinColumn(name = "FLOW_ID", insertable = false, updatable = false)
	private EventFlow eventFlow;

	@OneToOne
	@JoinColumn(name = "BEAN_ID", insertable = false, updatable = false)
	private EventBean eventBean;

	/**
	 * @return the eventRule
	 */
	public EventRule getEventRule() {
		return eventRule;
	}

	/**
	 * @param eventRule
	 *            the eventRule to set
	 */
	public void setEventRule(final EventRule eventRule) {
		this.eventRule = eventRule;
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
	 * @param flowId
	 *            the flowId to set
	 */
	public EventRuleMapKey getKey() {
		return key;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append("key").toHashCode();
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final EventRuleMap other = (EventRuleMap) obj;
		if (eventBean == null) {
			if (other.eventBean != null)
				return false;
		} else if (!eventBean.equals(other.eventBean))
			return false;
		if (eventFlow == null) {
			if (other.eventFlow != null)
				return false;
		} else if (!eventFlow.equals(other.eventFlow))
			return false;
		if (eventRule == null) {
			if (other.eventRule != null)
				return false;
		} else if (!eventRule.equals(other.eventRule))
			return false;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		return true;
	}

}
