package com.scb.event.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EVENT_NODE")
public class EventNode implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "NODE_ID", length = 120)
	private String id;

	@Column(name = "NODE_DESC", length = 1024)
	private String description;

	@Column(name = "RETENTION_DAYS", length = 10)
	private Integer retentionDays;

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
	 * @return the retentionDays
	 */
	public Integer getRetentionDays() {
		return retentionDays;
	}

	/**
	 * @param retentionDays
	 *            the retentionDays to set
	 */
	public void setRetentionDays(final Integer retentionDays) {
		this.retentionDays = retentionDays;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((retentionDays == null) ? 0 : retentionDays.hashCode());
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
		final EventNode other = (EventNode) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (retentionDays == null) {
			if (other.retentionDays != null)
				return false;
		} else if (!retentionDays.equals(other.retentionDays))
			return false;
		return true;
	}

}
