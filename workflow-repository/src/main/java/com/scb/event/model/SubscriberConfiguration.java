package com.scb.event.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang.builder.HashCodeBuilder;

@Entity
@Table(name = "SUBSCRIBER_CONFIGURATION")
public class SubscriberConfiguration implements Serializable {

	private static final long serialVersionUID = 3351311666977447933L;

	@Id
	@Column(name = "SUBSCRIBER_ID")
	private String subscriberId;

	@Column(name = "INITIAL_CONTEXT_FACTORY", length = 512)
	private String initialContextFactory;

	@Column(name = "PROVIDER_URL", length = 512)
	private String providerUrl;

	@Column(name = "CONNECTION_FACTORY", length = 512)
	private String connectionFactory;

	@Column(name = "USERNAME", length = 32)
	private String username;

	@Column(name = "PASSWORD", length = 32)
	private String password;

	@Column(name = "IS_SESSION_TRANSACTED", length = 1)
	private Boolean sessionTransacted;

	@Column(name = "ACKNOWLEDGMENT_MODE")
	@Enumerated(EnumType.STRING)
	private AcknowledgmentMode acknowledgmentMode;

	@Column(name = "DESTINATION", length = 512)
	private String destination;

	@Column(name = "LISTENER", length = 512)
	private String listener;

	/**
	 * @return the subscriberId
	 */
	public String getSubscriberId() {
		return subscriberId;
	}

	/**
	 * @param subscriberId
	 *            the subscriberId to set
	 */
	public void setSubscriberId(final String subscriberId) {
		this.subscriberId = subscriberId;
	}

	/**
	 * @return the initialContextFactory
	 */
	public String getInitialContextFactory() {
		return initialContextFactory;
	}

	/**
	 * @param initialContextFactory
	 *            the initialContextFactory to set
	 */
	public void setInitialContextFactory(final String initialContextFactory) {
		this.initialContextFactory = initialContextFactory;
	}

	/**
	 * @return the providerUrl
	 */
	public String getProviderUrl() {
		return providerUrl;
	}

	/**
	 * @param providerUrl
	 *            the providerUrl to set
	 */
	public void setProviderUrl(final String providerUrl) {
		this.providerUrl = providerUrl;
	}

	/**
	 * @return the connectionFactory
	 */
	public String getConnectionFactory() {
		return connectionFactory;
	}

	/**
	 * @param connectionFactory
	 *            the connectionFactory to set
	 */
	public void setConnectionFactory(final String connectionFactory) {
		this.connectionFactory = connectionFactory;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username
	 *            the username to set
	 */
	public void setUsername(final String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(final String password) {
		this.password = password;
	}

	/**
	 * @return the sessionTransacted
	 */
	public Boolean getSessionTransacted() {
		return sessionTransacted;
	}

	/**
	 * @param sessionTransacted
	 *            the sessionTransacted to set
	 */
	public void setSessionTransacted(final Boolean sessionTransacted) {
		this.sessionTransacted = sessionTransacted;
	}

	/**
	 * @return the acknowledgmentMode
	 */
	public AcknowledgmentMode getAcknowledgmentMode() {
		return acknowledgmentMode;
	}

	/**
	 * @param acknowledgmentMode
	 *            the acknowledgmentMode to set
	 */
	public void setAcknowledgmentMode(final AcknowledgmentMode acknowledgmentMode) {
		this.acknowledgmentMode = acknowledgmentMode;
	}

	/**
	 * @return the destination
	 */
	public String getDestination() {
		return destination;
	}

	/**
	 * @param destination
	 *            the destination to set
	 */
	public void setDestination(final String destination) {
		this.destination = destination;
	}

	/**
	 * @return the listener
	 */
	public String getListener() {
		return listener;
	}

	/**
	 * @param listener
	 *            the listener to set
	 */
	public void setListener(final String listener) {
		this.listener = listener;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append("subscriberId").append("initialContextFactory").append("providerUrl")
				.append("connectionFactory").append("username").append("password").append("sessionTransacted")
				.append("acknowledgmentMode").append("acknowledgmentMode").append("destination").append("listener")
				.toHashCode();
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final SubscriberConfiguration other = (SubscriberConfiguration) obj;
		if (acknowledgmentMode != other.acknowledgmentMode)
			return false;
		if (connectionFactory == null) {
			if (other.connectionFactory != null)
				return false;
		} else if (!connectionFactory.equals(other.connectionFactory))
			return false;
		if (destination == null) {
			if (other.destination != null)
				return false;
		} else if (!destination.equals(other.destination))
			return false;
		if (initialContextFactory == null) {
			if (other.initialContextFactory != null)
				return false;
		} else if (!initialContextFactory.equals(other.initialContextFactory))
			return false;
		if (listener == null) {
			if (other.listener != null)
				return false;
		} else if (!listener.equals(other.listener))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (providerUrl == null) {
			if (other.providerUrl != null)
				return false;
		} else if (!providerUrl.equals(other.providerUrl))
			return false;
		if (sessionTransacted == null) {
			if (other.sessionTransacted != null)
				return false;
		} else if (!sessionTransacted.equals(other.sessionTransacted))
			return false;
		if (subscriberId == null) {
			if (other.subscriberId != null)
				return false;
		} else if (!subscriberId.equals(other.subscriberId))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

}
