package com.scb.event.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.apache.commons.lang.builder.HashCodeBuilder;

@Entity
@NamedQueries({
		@NamedQuery(name = EventFlow.EVENT_FLOW_FIND_BY_FLOW_ID, query = "SELECT c FROM EventFlow c left join fetch c.sourceNode left join fetch c.targetNode left join fetch c.action where c.id=:flowId"),
		@NamedQuery(name = EventFlow.FIND_BY_SOURCE_NODE_ID, query = "SELECT c FROM EventFlow c left join fetch c.sourceNode left join fetch c.targetNode left join fetch c.action  WHERE c.sourceNode.id = :sourceNodeId") })
@Table(name = "EVENT_FLOW", uniqueConstraints = @UniqueConstraint(columnNames = { "ACTION_ID", "SOURCE_NODE_ID",
		"TARGET_NODE_ID" }))
public class EventFlow implements Serializable {

	private static final long serialVersionUID = -692400349209587214L;

	public static final String EVENT_FLOW_FIND_BY_FLOW_ID = "Event_Flow_findByFlowId";

	public static final String FIND_BY_SOURCE_NODE_ID = "findBySourceNodeId";

	@Id
	@Column(name = "FLOW_ID", length = 120)
	@GeneratedValue
	private String id;

	@Column(name = "FLOW_DESC", length = 1024)
	private String description;

	@OneToOne
	@JoinColumn(name = "ACTION_ID")
	private EventAction action;

	@OneToOne
	@JoinColumn(name = "SOURCE_NODE_ID")
	private EventNode sourceNode;

	@OneToOne
	@JoinColumn(name = "TARGET_NODE_ID")
	private EventNode targetNode;

	@Column(name = "IS_RETRY_ENABLED")
	private Boolean retryEnabled;

	@Column(name = "FLOW_CATEGORY", length = 32)
	@Enumerated(EnumType.STRING)
	private FlowCategory flowCategory;

	@Column(name = "DELAY_FACTOR_IN_MINUTES", length = 10)
	private Integer delayFactorInMinutes;

	@Column(name = "RETRY_LIMIT_IN_HOUR", length = 10)
	private Integer retryLimitInHour;

	@Column(name = "SCAN_INTERVAL_IN_MINUTES", length = 10)
	private Integer scanIntervalInMinutes;

	@Column(name = "IS_RULE_EVAL_RETRY_ENABLED")
	private Boolean ruleEvaluationRetryEnabled;

	@Column(name = "CONCURRENT_CONSUMERS", length = 10)
	private Integer concurrentConsumers = 3;

	@Column(name = "MAX_CONCURRENT_CONSUMERS", length = 10)
	private Integer maxConcurrentConsumers = 10;

	@Column(name = "CHUNK_PROCESSING_ENABLED")
	private Boolean chunkProcessingEnabled;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(final String id) {
		this.id = id;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(final String description) {
		this.description = description;
	}

	/**
	 * @return the action
	 */
	public EventAction getAction() {
		return action;
	}

	/**
	 * @param action
	 *            the action to set
	 */
	public void setAction(final EventAction action) {
		this.action = action;
	}

	/**
	 * @return the sourceNode
	 */
	public EventNode getSourceNode() {
		return sourceNode;
	}

	/**
	 * @param sourceNode
	 *            the sourceNode to set
	 */
	public void setSourceNode(final EventNode sourceNode) {
		this.sourceNode = sourceNode;
	}

	/**
	 * @return the targetNode
	 */
	public EventNode getTargetNode() {
		return targetNode;
	}

	/**
	 * @param targetNode
	 *            the targetNode to set
	 */
	public void setTargetNode(final EventNode targetNode) {
		this.targetNode = targetNode;
	}

	/**
	 * @return the retryEnabled
	 */
	public Boolean getRetryEnabled() {
		return retryEnabled;
	}

	/**
	 * @param retryEnabled
	 *            the retryEnabled to set
	 */
	public void setRetryEnabled(final Boolean retryEnabled) {
		this.retryEnabled = retryEnabled;
	}

	/**
	 * @return the flowCategory
	 */
	public FlowCategory getFlowCategory() {
		return flowCategory;
	}

	/**
	 * @param flowCategory
	 *            the flowCategory to set
	 */
	public void setFlowCategory(final FlowCategory flowCategory) {
		this.flowCategory = flowCategory;
	}

	/**
	 * @return the delayFactorInMinutes
	 */
	public Integer getDelayFactorInMinutes() {
		return delayFactorInMinutes;
	}

	/**
	 * @param delayFactorInMinutes
	 *            the delayFactorInMinutes to set
	 */
	public void setDelayFactorInMinutes(final Integer delayFactorInMinutes) {
		this.delayFactorInMinutes = delayFactorInMinutes;
	}

	/**
	 * @return the retryLimitInHour
	 */
	public Integer getRetryLimitInHour() {
		return retryLimitInHour;
	}

	/**
	 * @param retryLimitInHour
	 *            the retryLimitInHour to set
	 */
	public void setRetryLimitInHour(final Integer retryLimitInHour) {
		this.retryLimitInHour = retryLimitInHour;
	}

	/**
	 * @return the scanIntervalInMinutes
	 */
	public Integer getScanIntervalInMinutes() {
		return scanIntervalInMinutes;
	}

	/**
	 * @param scanIntervalInMinutes
	 *            the scanIntervalInMinutes to set
	 */
	public void setScanIntervalInMinutes(final Integer scanIntervalInMinutes) {
		this.scanIntervalInMinutes = scanIntervalInMinutes;
	}

	/**
	 * @return the ruleEvaluationRetryEnabled
	 */
	public Boolean getRuleEvaluationRetryEnabled() {
		return ruleEvaluationRetryEnabled;
	}

	/**
	 * @param ruleEvaluationRetryEnabled
	 *            the ruleEvaluationRetryEnabled to set
	 */
	public void setRuleEvaluationRetryEnabled(final Boolean ruleEvaluationRetryEnabled) {
		this.ruleEvaluationRetryEnabled = ruleEvaluationRetryEnabled;
	}

	/**
	 * @return the concurrentConsumers
	 */
	public Integer getConcurrentConsumers() {
		return concurrentConsumers;
	}

	/**
	 * @param concurrentConsumers
	 *            the concurrentConsumers to set
	 */
	public void setConcurrentConsumers(final Integer concurrentConsumers) {
		this.concurrentConsumers = concurrentConsumers;
	}

	/**
	 * @return the maxConcurrentConsumers
	 */
	public Integer getMaxConcurrentConsumers() {
		return maxConcurrentConsumers;
	}

	/**
	 * @param maxConcurrentConsumers
	 *            the maxConcurrentConsumers to set
	 */
	public void setMaxConcurrentConsumers(final Integer maxConcurrentConsumers) {
		this.maxConcurrentConsumers = maxConcurrentConsumers;
	}

	/**
	 * @return the chunkProcessingEnabled
	 */
	public Boolean getChunkProcessingEnabled() {
		return chunkProcessingEnabled;
	}

	/**
	 * @param chunkProcessingEnabled
	 *            the chunkProcessingEnabled to set
	 */
	public void setChunkProcessingEnabled(final Boolean chunkProcessingEnabled) {
		this.chunkProcessingEnabled = chunkProcessingEnabled;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append("id").append("description").append("retryEnabled").append("flowCategory")
				.append("delayFactorInMinutes").append("retryLimitInHour").append("scanIntervalInMinutes")
				.append("ruleEvaluationRetryEnabled").append("concurrentConsumers").append("maxConcurrentConsumers")
				.append("chunkProcessingEnabled").toHashCode();
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final EventFlow other = (EventFlow) obj;
		if (action == null) {
			if (other.action != null)
				return false;
		} else if (!action.equals(other.action))
			return false;
		if (chunkProcessingEnabled == null) {
			if (other.chunkProcessingEnabled != null)
				return false;
		} else if (!chunkProcessingEnabled.equals(other.chunkProcessingEnabled))
			return false;
		if (concurrentConsumers == null) {
			if (other.concurrentConsumers != null)
				return false;
		} else if (!concurrentConsumers.equals(other.concurrentConsumers))
			return false;
		if (delayFactorInMinutes == null) {
			if (other.delayFactorInMinutes != null)
				return false;
		} else if (!delayFactorInMinutes.equals(other.delayFactorInMinutes))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (flowCategory != other.flowCategory)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (maxConcurrentConsumers == null) {
			if (other.maxConcurrentConsumers != null)
				return false;
		} else if (!maxConcurrentConsumers.equals(other.maxConcurrentConsumers))
			return false;
		if (retryEnabled == null) {
			if (other.retryEnabled != null)
				return false;
		} else if (!retryEnabled.equals(other.retryEnabled))
			return false;
		if (retryLimitInHour == null) {
			if (other.retryLimitInHour != null)
				return false;
		} else if (!retryLimitInHour.equals(other.retryLimitInHour))
			return false;
		if (ruleEvaluationRetryEnabled == null) {
			if (other.ruleEvaluationRetryEnabled != null)
				return false;
		} else if (!ruleEvaluationRetryEnabled.equals(other.ruleEvaluationRetryEnabled))
			return false;
		if (scanIntervalInMinutes == null) {
			if (other.scanIntervalInMinutes != null)
				return false;
		} else if (!scanIntervalInMinutes.equals(other.scanIntervalInMinutes))
			return false;
		if (sourceNode == null) {
			if (other.sourceNode != null)
				return false;
		} else if (!sourceNode.equals(other.sourceNode))
			return false;
		if (targetNode == null) {
			if (other.targetNode != null)
				return false;
		} else if (!targetNode.equals(other.targetNode))
			return false;
		return true;
	}

}
