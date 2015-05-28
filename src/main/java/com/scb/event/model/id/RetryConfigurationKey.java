package com.scb.event.model.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class RetryConfigurationKey implements Serializable {

	private static final long serialVersionUID = -4447580048133393649L;

	@Column(name = "FLOW_ID")
	private String flowId;

	@Column(name = "RETRY_EXCEPTION")
	private String retryException;

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
	 * @return the retryException
	 */
	public String getRetryException() {
		return retryException;
	}

	/**
	 * @param retryException
	 *            the retryException to set
	 */
	public void setRetryException(String retryException) {
		this.retryException = retryException;
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
		result = prime * result + ((flowId == null) ? 0 : flowId.hashCode());
		result = prime * result + ((retryException == null) ? 0 : retryException.hashCode());
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
		RetryConfigurationKey other = (RetryConfigurationKey) obj;
		if (flowId == null) {
			if (other.flowId != null)
				return false;
		} else if (!flowId.equals(other.flowId))
			return false;
		if (retryException == null) {
			if (other.retryException != null)
				return false;
		} else if (!retryException.equals(other.retryException))
			return false;
		return true;
	}

}
