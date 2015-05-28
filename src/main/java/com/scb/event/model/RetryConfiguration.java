package com.scb.event.model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.apache.commons.lang.builder.HashCodeBuilder;

import com.scb.event.model.id.RetryConfigurationKey;

@Entity
@NamedQuery(name = RetryConfiguration.RETRY_CONFIGURATION_FIND_BY_FLOW_ID, query = "select c from RetryConfiguration c where c.key.flowId=:flowId")
@Table(name = "EVENT_RETRY_CONFIGURATION")
public class RetryConfiguration implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final String RETRY_CONFIGURATION_FIND_BY_FLOW_ID = "RetryConfiguration_findByFlowId";

	@EmbeddedId
	private RetryConfigurationKey key;

	@OneToOne
	@JoinColumn(name = "FLOW_ID", insertable = false, updatable = false)
	private EventFlow eventFlow;

	/**
	 * @return the key
	 */
	public RetryConfigurationKey getKey() {
		return key;
	}

	/**
	 * @param key
	 *            the key to set
	 */
	public void setKey(final RetryConfigurationKey key) {
		this.key = key;
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
		final RetryConfiguration other = (RetryConfiguration) obj;
		if (eventFlow == null) {
			if (other.eventFlow != null)
				return false;
		} else if (!eventFlow.equals(other.eventFlow))
			return false;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		return true;
	}

}