package com.scb.event.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.commons.lang.builder.HashCodeBuilder;

@Entity
@Table(name = "EVENT_ACTION")
public class EventAction implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ACTION_ID", length = 120)
	private String id;

	@Column(name = "ACTION_DESC", length = 1024)
	private String description;

	@OneToMany(mappedBy = "eventAction")
	private Set<EventActionOutBean> eventActionOutBeans;

	public String getId() {
		return id;
	}

	public void setId(final String id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(final String description) {
		this.description = description;
	}

	public Set<EventActionOutBean> getEventActionOutBeans() {
		return eventActionOutBeans;
	}

	public void setEventActionOutBeans(final Set<EventActionOutBean> eventActionOutBeans) {
		this.eventActionOutBeans = eventActionOutBeans;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append("id").append("description").toHashCode();
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final EventAction other = (EventAction) obj;
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
		return true;
	}

}