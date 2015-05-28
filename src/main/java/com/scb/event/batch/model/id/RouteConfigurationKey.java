package com.scb.event.batch.model.id;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * RouteConfigurationKey defines the Composite Key for the RouteConfiguration
 * Entity.
 * 
 * @author 1434190
 * 
 */
@Embeddable
public class RouteConfigurationKey implements Serializable {

	/** Generated SerialVersionUID */
	private static final long serialVersionUID = -213948931937206919L;

	@Column(name = "JOB_ID")
	private BigInteger jobId;

	@Column(name = "ROUTE_SEQUENCE")
	private Integer routeSequence;

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
	 * @return the routeSequence
	 */
	public Integer getRouteSequence() {
		return routeSequence;
	}

	/**
	 * @param routeSequence
	 *            the routeSequence to set
	 */
	public void setRouteSequence(Integer routeSequence) {
		this.routeSequence = routeSequence;
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
		result = prime * result + ((routeSequence == null) ? 0 : routeSequence.hashCode());
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
		RouteConfigurationKey other = (RouteConfigurationKey) obj;
		if (jobId == null) {
			if (other.jobId != null)
				return false;
		} else if (!jobId.equals(other.jobId))
			return false;
		if (routeSequence == null) {
			if (other.routeSequence != null)
				return false;
		} else if (!routeSequence.equals(other.routeSequence))
			return false;
		return true;
	}

}
