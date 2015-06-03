package com.scb.event.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.commons.lang.builder.HashCodeBuilder;

@Entity
@NamedQuery(name = EventBean.EVENT_BEAN_FIND_BY_BEAN_CLASS, query = "SELECT c FROM EventBean c JOIN FETCH c.attributes WHERE c.beanClass =:beanClass")
@Table(name = "EVENT_BEAN")
public class EventBean implements Serializable {

	private static final long serialVersionUID = 2513259293647446013L;

	public static final String EVENT_BEAN_FIND_BY_BEAN_CLASS = "EventBean_findByBeanClass";

	@Id
	@Column(name = "BEAN_ID", length = 120)
	@GeneratedValue
	private String id;

	@Column(name = "BEAN_CLASS", length = 1024)
	private String beanClass;

	@OneToMany(mappedBy = "eventBean")
	private Set<EventBeanAttribute> attributes;

	public String getId() {
		return id;
	}

	public void setId(final String id) {
		this.id = id;
	}

	public String getBeanClass() {
		return beanClass;
	}

	public void setBeanClass(final String beanClass) {
		this.beanClass = beanClass;
	}

	public Set<EventBeanAttribute> getAttributes() {
		return attributes;
	}

	public void setAttributes(final Set<EventBeanAttribute> attributes) {
		this.attributes = attributes;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append("id").append("beanClass").toHashCode();
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final EventBean other = (EventBean) obj;
		if (attributes == null) {
			if (other.attributes != null)
				return false;
		} else if (!attributes.equals(other.attributes))
			return false;
		if (beanClass == null) {
			if (other.beanClass != null)
				return false;
		} else if (!beanClass.equals(other.beanClass))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
