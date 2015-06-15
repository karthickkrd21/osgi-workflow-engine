package com.scb.event.workflow.model;

import java.io.Serializable;

public class ProcessContext implements Serializable {

	/** Default SerialVersionUID */
	private static final long serialVersionUID = 1L;

	private String flowId;
	private String actionId;
	private String applicationGroup;
	private String function;
	private String country;
	private String entity;
	private String instanceCode;
	private String userId;
	private Boolean chunkProcessingEnabled = Boolean.FALSE;

	/**
	 * @return the flowId
	 */
	public String getFlowId() {
		return flowId;
	}

	/**
	 * @param flowId
	 *            the flowId to set
	 */
	public void setFlowId(String flowId) {
		this.flowId = flowId;
	}

	/**
	 * @return the actionId
	 */
	public String getActionId() {
		return actionId;
	}

	/**
	 * @param actionId
	 *            the actionId to set
	 */
	public void setActionId(String actionId) {
		this.actionId = actionId;
	}

	/**
	 * @return the applicationGroup
	 */
	public String getApplicationGroup() {
		return applicationGroup;
	}

	/**
	 * @param applicationGroup
	 *            the applicationGroup to set
	 */
	public void setApplicationGroup(String applicationGroup) {
		this.applicationGroup = applicationGroup;
	}

	/**
	 * @return the function
	 */
	public String getFunction() {
		return function;
	}

	/**
	 * @param function
	 *            the function to set
	 */
	public void setFunction(String function) {
		this.function = function;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country
	 *            the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return the entity
	 */
	public String getEntity() {
		return entity;
	}

	/**
	 * @param entity
	 *            the entity to set
	 */
	public void setEntity(String entity) {
		this.entity = entity;
	}

	/**
	 * @return the instanceCode
	 */
	public String getInstanceCode() {
		return instanceCode;
	}

	/**
	 * @param instanceCode
	 *            the instanceCode to set
	 */
	public void setInstanceCode(String instanceCode) {
		this.instanceCode = instanceCode;
	}

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
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
	public void setChunkProcessingEnabled(Boolean chunkProcessingEnabled) {
		this.chunkProcessingEnabled = chunkProcessingEnabled;
	}

}
