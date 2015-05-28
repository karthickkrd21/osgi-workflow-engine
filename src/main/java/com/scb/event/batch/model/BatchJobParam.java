package com.scb.event.batch.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.scb.event.batch.model.id.BatchJobParamKey;

@Entity
@Table(name = "BATCH_JOB_PARAM")
public class BatchJobParam implements Serializable {

	/** Generated SerialVersionUID */
	private static final long serialVersionUID = -8043998937588621680L;

	@EmbeddedId
	private BatchJobParamKey key;

	@ManyToOne
	@JoinColumn(name = "JOB_ID", insertable = false, updatable = false)
	private BatchJobConfiguration jobConfiguration;

	@Column(name = "JOB_PARAM_VALUE", length = 512)
	private String jobParamValue;

	/**
	 * @return the key
	 */
	public BatchJobParamKey getKey() {
		return key;
	}

	/**
	 * @param key
	 *            the key to set
	 */
	public void setKey(final BatchJobParamKey key) {
		this.key = key;
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
	public void setJobConfiguration(final BatchJobConfiguration jobConfiguration) {
		this.jobConfiguration = jobConfiguration;
	}

	/**
	 * @return the jobParamValue
	 */
	public String getJobParamValue() {
		return jobParamValue;
	}

	/**
	 * @param jobParamValue
	 *            the jobParamValue to set
	 */
	public void setJobParamValue(final String jobParamValue) {
		this.jobParamValue = jobParamValue;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((jobConfiguration == null) ? 0 : jobConfiguration.hashCode());
		result = prime * result + ((jobParamValue == null) ? 0 : jobParamValue.hashCode());
		result = prime * result + ((key == null) ? 0 : key.hashCode());
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final BatchJobParam other = (BatchJobParam) obj;
		if (jobConfiguration == null) {
			if (other.jobConfiguration != null)
				return false;
		} else if (!jobConfiguration.equals(other.jobConfiguration))
			return false;
		if (jobParamValue == null) {
			if (other.jobParamValue != null)
				return false;
		} else if (!jobParamValue.equals(other.jobParamValue))
			return false;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		return true;
	}

}
