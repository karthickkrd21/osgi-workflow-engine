package com.scb.event.batch.model.id;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * BatchJobParamKey defines the Composite Key for the BatchJobParam Entity.
 * 
 * @author 1434190
 * 
 */
@Embeddable
public class BatchJobParamKey implements Serializable {

	/** Generated SerialVersionUID */
	private static final long serialVersionUID = -9017407858994119693L;

	@Column(name = "JOB_ID")
	private BigInteger jobId;

	@Column(name = "JOB_PARAM_KEY")
	private String jobParamKey;

	/**
	 * @return the jobId
	 */
	public BigInteger getJobId() {
		return jobId;
	}

	/**
	 * @param jobId
	 *            the jobId to set
	 */
	public void setJobId(BigInteger jobId) {
		this.jobId = jobId;
	}

	/**
	 * @return the jobParamKey
	 */
	public String getJobParamKey() {
		return jobParamKey;
	}

	/**
	 * @param jobParamKey
	 *            the jobParamKey to set
	 */
	public void setJobParamKey(String jobParamKey) {
		this.jobParamKey = jobParamKey;
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
		result = prime * result + ((jobId == null) ? 0 : jobId.hashCode());
		result = prime * result + ((jobParamKey == null) ? 0 : jobParamKey.hashCode());
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
		BatchJobParamKey other = (BatchJobParamKey) obj;
		if (jobId == null) {
			if (other.jobId != null)
				return false;
		} else if (!jobId.equals(other.jobId))
			return false;
		if (jobParamKey == null) {
			if (other.jobParamKey != null)
				return false;
		} else if (!jobParamKey.equals(other.jobParamKey))
			return false;
		return true;
	}

}
