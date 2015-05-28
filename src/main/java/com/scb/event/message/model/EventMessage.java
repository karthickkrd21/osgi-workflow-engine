package com.scb.event.message.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.apache.commons.lang.builder.HashCodeBuilder;

import com.scb.event.model.EventAction;
import com.scb.event.model.EventNode;

@Entity
@Table(name = "EVENT_MESSAGE")
public class EventMessage implements Serializable {

	private static final long serialVersionUID = -5769341921938385861L;

	@Id
	@Column(name = "MESSAGE_ID", precision = 38, scale = 0)
	@GeneratedValue
	private BigDecimal messageId;

	@OneToOne
	@JoinColumn(name = "NODE_ID", insertable = true, updatable = true)
	private EventNode node;

	@OneToOne
	@JoinColumn(name = "ACTION_ID", insertable = true, updatable = true)
	private EventAction action;

	@OneToOne
	@JoinColumn(name = "ORIGINAL_MESSAGE_ID", insertable = true, updatable = true)
	private EventMessage originalMessage;

	@OneToOne
	@JoinColumn(name = "PREVIOUS_MESSAGE_ID", insertable = true, updatable = true)
	private EventMessage previousMessage;

	@Column(name = "VERSION", length = 30)
	private String version;

	@Column(name = "REFERENCE_ID")
	private String referenceId;

	@Column(name = "APPLICATION_GROUP")
	private String applicationGroup;

	@Column(name = "ENTITY")
	private String entity;

	@Column(name = "INSTANCE")
	private String instance;

	@Column(name = "MODULE")
	private String module;

	@Column(name = "COUNTRY")
	private String country;

	@Column(name = "PAYLOAD_TYPE")
	@Enumerated(EnumType.STRING)
	private MessageType payloadType;

	@Column(name = "PAYLOAD_SUB_TYPE")
	private String payloadSubType;

	@Column(name = "IS_PUBLISHED")
	private boolean published;

	@Column(name = "DATE_CREATED")
	private Date createdOn;

	@Column(name = "DATE_UPDATED")
	private Date updatedOn;

	@Column(name = "USER_CREATED")
	private String createdBy;

	@Column(name = "USER_UPDATED")
	private String updatedBy;

	@Column(name = "PAYLOAD")
	@Lob
	private String payload;

	@OneToMany(mappedBy = "eventMessage", cascade = CascadeType.PERSIST)
	private Set<EventMessageAttribute> attributes;

	/**
	 * @return the messageId
	 */
	public BigDecimal getMessageId() {
		return messageId;
	}

	/**
	 * @param messageId
	 *            the messageId to set
	 */
	public void setMessageId(final BigDecimal messageId) {
		this.messageId = messageId;
	}

	/**
	 * @return the node
	 */
	public EventNode getNode() {
		return node;
	}

	/**
	 * @param node
	 *            the node to set
	 */
	public void setNode(final EventNode node) {
		this.node = node;
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
	 * @return the originalMessage
	 */
	public EventMessage getOriginalMessage() {
		return originalMessage;
	}

	/**
	 * @param originalMessage
	 *            the originalMessage to set
	 */
	public void setOriginalMessage(final EventMessage originalMessage) {
		this.originalMessage = originalMessage;
	}

	/**
	 * @return the previousMessage
	 */
	public EventMessage getPreviousMessage() {
		return previousMessage;
	}

	/**
	 * @param previousMessage
	 *            the previousMessage to set
	 */
	public void setPreviousMessage(final EventMessage previousMessage) {
		this.previousMessage = previousMessage;
	}

	/**
	 * @return the version
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * @param version
	 *            the version to set
	 */
	public void setVersion(final String version) {
		this.version = version;
	}

	/**
	 * @return the referenceId
	 */
	public String getReferenceId() {
		return referenceId;
	}

	/**
	 * @param referenceId
	 *            the referenceId to set
	 */
	public void setReferenceId(final String referenceId) {
		this.referenceId = referenceId;
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
	public void setApplicationGroup(final String applicationGroup) {
		this.applicationGroup = applicationGroup;
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
	public void setEntity(final String entity) {
		this.entity = entity;
	}

	/**
	 * @return the instance
	 */
	public String getInstance() {
		return instance;
	}

	/**
	 * @param instance
	 *            the instance to set
	 */
	public void setInstance(final String instance) {
		this.instance = instance;
	}

	/**
	 * @return the module
	 */
	public String getModule() {
		return module;
	}

	/**
	 * @param module
	 *            the module to set
	 */
	public void setModule(final String module) {
		this.module = module;
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
	public void setCountry(final String country) {
		this.country = country;
	}

	/**
	 * @return the payloadType
	 */
	public MessageType getPayloadType() {
		return payloadType;
	}

	/**
	 * @param payloadType
	 *            the payloadType to set
	 */
	public void setPayloadType(final MessageType payloadType) {
		this.payloadType = payloadType;
	}

	/**
	 * @return the payloadSubType
	 */
	public String getPayloadSubType() {
		return payloadSubType;
	}

	/**
	 * @param payloadSubType
	 *            the payloadSubType to set
	 */
	public void setPayloadSubType(final String payloadSubType) {
		this.payloadSubType = payloadSubType;
	}

	/**
	 * @return the published
	 */
	public boolean isPublished() {
		return published;
	}

	/**
	 * @param published
	 *            the published to set
	 */
	public void setPublished(final boolean published) {
		this.published = published;
	}

	/**
	 * @return the createdOn
	 */
	public Date getCreatedOn() {
		return createdOn;
	}

	/**
	 * @param createdOn
	 *            the createdOn to set
	 */
	public void setCreatedOn(final Date createdOn) {
		this.createdOn = createdOn;
	}

	/**
	 * @return the updatedOn
	 */
	public Date getUpdatedOn() {
		return updatedOn;
	}

	/**
	 * @param updatedOn
	 *            the updatedOn to set
	 */
	public void setUpdatedOn(final Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	/**
	 * @return the createdBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy
	 *            the createdBy to set
	 */
	public void setCreatedBy(final String createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * @return the updatedBy
	 */
	public String getUpdatedBy() {
		return updatedBy;
	}

	/**
	 * @param updatedBy
	 *            the updatedBy to set
	 */
	public void setUpdatedBy(final String updatedBy) {
		this.updatedBy = updatedBy;
	}

	/**
	 * @return the attributes
	 */
	public Set<EventMessageAttribute> getAttributes() {
		return attributes;
	}

	/**
	 * @param attributes
	 *            the attributes to set
	 */
	public void setAttributes(final Set<EventMessageAttribute> attributes) {
		this.attributes = attributes;
	}

	/**
	 * @return the payload
	 */
	public String getPayload() {
		return payload;
	}

	/**
	 * @param payload
	 *            the payload to set
	 */
	public void setPayload(final String payload) {
		this.payload = payload;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append("messageId").append("referenceId").append("version")
				.append("applicationGroup").append("entity").append("instance").append("module").append("country")
				.append("payloadType").append("payloadSubType").append("published").append("createdOn")
				.append("updatedOn").append("createdBy").append("updatedBy").append("payload").toHashCode();
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final EventMessage other = (EventMessage) obj;
		if (action == null) {
			if (other.action != null)
				return false;
		} else if (!action.equals(other.action))
			return false;
		if (applicationGroup == null) {
			if (other.applicationGroup != null)
				return false;
		} else if (!applicationGroup.equals(other.applicationGroup))
			return false;
		if (attributes == null) {
			if (other.attributes != null)
				return false;
		} else if (!attributes.equals(other.attributes))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (createdBy == null) {
			if (other.createdBy != null)
				return false;
		} else if (!createdBy.equals(other.createdBy))
			return false;
		if (createdOn == null) {
			if (other.createdOn != null)
				return false;
		} else if (!createdOn.equals(other.createdOn))
			return false;
		if (entity == null) {
			if (other.entity != null)
				return false;
		} else if (!entity.equals(other.entity))
			return false;
		if (instance == null) {
			if (other.instance != null)
				return false;
		} else if (!instance.equals(other.instance))
			return false;
		if (messageId == null) {
			if (other.messageId != null)
				return false;
		} else if (!messageId.equals(other.messageId))
			return false;
		if (module == null) {
			if (other.module != null)
				return false;
		} else if (!module.equals(other.module))
			return false;
		if (node == null) {
			if (other.node != null)
				return false;
		} else if (!node.equals(other.node))
			return false;
		if (originalMessage == null) {
			if (other.originalMessage != null)
				return false;
		} else if (!originalMessage.equals(other.originalMessage))
			return false;
		if (payload == null) {
			if (other.payload != null)
				return false;
		} else if (!payload.equals(other.payload))
			return false;
		if (payloadSubType == null) {
			if (other.payloadSubType != null)
				return false;
		} else if (!payloadSubType.equals(other.payloadSubType))
			return false;
		if (payloadType != other.payloadType)
			return false;
		if (previousMessage == null) {
			if (other.previousMessage != null)
				return false;
		} else if (!previousMessage.equals(other.previousMessage))
			return false;
		if (published != other.published)
			return false;
		if (referenceId == null) {
			if (other.referenceId != null)
				return false;
		} else if (!referenceId.equals(other.referenceId))
			return false;
		if (updatedBy == null) {
			if (other.updatedBy != null)
				return false;
		} else if (!updatedBy.equals(other.updatedBy))
			return false;
		if (updatedOn == null) {
			if (other.updatedOn != null)
				return false;
		} else if (!updatedOn.equals(other.updatedOn))
			return false;
		if (version == null) {
			if (other.version != null)
				return false;
		} else if (!version.equals(other.version))
			return false;
		return true;
	}

}
