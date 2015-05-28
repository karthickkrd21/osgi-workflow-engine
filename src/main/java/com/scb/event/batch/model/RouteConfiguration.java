package com.scb.event.batch.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.scb.event.batch.model.id.RouteConfigurationKey;

@Entity
@Table(name = "ROUTE_CONFIGURATION")
public class RouteConfiguration implements Serializable {

	/** Generated SerialVersionUID */
	private static final long serialVersionUID = 1150211994228765907L;

	@EmbeddedId
	private RouteConfigurationKey key;

	@Column(name = "ENDPOINT_URI", length = 2000)
	private String endPointUri;

	@ManyToOne
	@JoinColumn(name = "JOB_ID", insertable = false, updatable = false)
	private BatchJobConfiguration jobConfiguration;

	/**
	 * @return the key
	 */
	public RouteConfigurationKey getKey() {
		return key;
	}

	/**
	 * @param key
	 *            the key to set
	 */
	public void setKey(RouteConfigurationKey key) {
		this.key = key;
	}

	/**
	 * @return the endPointUri
	 */
	public String getEndPointUri() {
		return endPointUri;
	}

	/**
	 * @param endPointUri
	 *            the endPointUri to set
	 */
	public void setEndPointUri(String endPointUri) {
		this.endPointUri = endPointUri;
	}

	/**
	 * @return the jobConfiguration
	 */
	public BatchJobConfiguration getJobConfiguration() {
		return jobConfiguration;
	}

	/**
	 * @param jobConfiguration
	 *            the jobConfiguration to set
	 */
	public void setJobConfiguration(BatchJobConfiguration jobConfiguration) {
		this.jobConfiguration = jobConfiguration;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((endPointUri == null) ? 0 : endPointUri.hashCode());
		result = prime
				* result
				+ ((jobConfiguration == null) ? 0 : jobConfiguration.hashCode());
		result = prime * result + ((key == null) ? 0 : key.hashCode());
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
		RouteConfiguration other = (RouteConfiguration) obj;
		if (endPointUri == null) {
			if (other.endPointUri != null)
				return false;
		} else if (!endPointUri.equals(other.endPointUri))
			return false;
		if (jobConfiguration == null) {
			if (other.jobConfiguration != null)
				return false;
		} else if (!jobConfiguration.equals(other.jobConfiguration))
			return false;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		return true;
	}
	
	

}
