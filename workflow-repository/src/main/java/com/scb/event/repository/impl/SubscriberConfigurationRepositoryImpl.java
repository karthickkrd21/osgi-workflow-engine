package com.scb.event.repository.impl;

import javax.persistence.EntityManager;

import com.scb.event.model.SubscriberConfiguration;
import com.scb.wb.generic.repository.impl.GenericCrudRepositoryImpl;

public class SubscriberConfigurationRepositoryImpl extends GenericCrudRepositoryImpl<SubscriberConfiguration, String> {

	private EntityManager entityManager;

	@Override
	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(final EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void init() {
		System.out.println("Init Method in subscriber Configuration Respistory");
		/*
		 * final SubscriberConfiguration subscriberConfiguration = new SubscriberConfiguration();
		 * subscriberConfiguration.setAcknowledgmentMode(AcknowledgmentMode.AUTO_ACKNOWLEDGE);
		 * subscriberConfiguration.setConnectionFactory("connection");
		 * subscriberConfiguration.setDestination("destination");
		 * subscriberConfiguration.setInitialContextFactory("initial"); subscriberConfiguration.setListener("listener");
		 * subscriberConfiguration.setPassword("password"); subscriberConfiguration.setProviderUrl("provider");
		 * subscriberConfiguration.setSessionTransacted(Boolean.TRUE); subscriberConfiguration.setSubscriberId("099");
		 * subscriberConfiguration.setUsername("karthick"); this.save(subscriberConfiguration);
		 */
		System.out.println("saved into subscriber configuration repository");
	}
}
