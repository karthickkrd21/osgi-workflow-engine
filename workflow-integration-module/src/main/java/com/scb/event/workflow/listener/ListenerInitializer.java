package com.scb.event.workflow.listener;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.commons.collections.CollectionUtils;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.service.blueprint.container.BlueprintContainer;

import com.scb.event.model.AcknowledgmentMode;
import com.scb.event.model.SubscriberConfiguration;
import com.scb.event.repository.ConfigurationRepository;
import com.scb.event.repository.SubscriberConfigurationRepository;

public class ListenerInitializer {

	private ConnectionFactory factory;
	private Connection connection;
	private Session session;
	private Destination destination;
	private MessageConsumer consumer;
	private BlueprintContainer container;
	private ConfigurationRepository configurationRepository;
	private SubscriberConfigurationRepository subscriberConfigurationRepository;
	private BundleContext bundleContext;

	public void init() throws JMSException, ClassNotFoundException {
		System.out.println("inside the listener Creation of Receiver Class");
		final List<String> flowIds = configurationRepository.findAllNotEmptySourceNodes();
		final SubscriberConfiguration subscriberConfiguration = subscriberConfigurationRepository
				.fetch("EventFlow_InternalSubscriber");
		if (subscriberConfiguration != null) {
			System.out.println("Subscriber Configuration is not null");
			factory = new ActiveMQConnectionFactory(subscriberConfiguration.getUsername(),
					subscriberConfiguration.getPassword(), subscriberConfiguration.getProviderUrl());
			connection = factory.createConnection();
			connection.start();
			if (CollectionUtils.isNotEmpty(flowIds)) {
				for (final String flowId : flowIds) {
					final String queueName = "StaticQueue_" + flowId;
					for (final String containerIds : container.getComponentIds()) {
						System.out.println("Container Ids: " + containerIds);
					}
					// if (!container.getComponentIds().contains(queueName)) {
					session = connection.createSession(subscriberConfiguration.getSessionTransacted(),
							getAcknowlegmentMode(subscriberConfiguration.getAcknowledgmentMode()));
					destination = session.createQueue(queueName);
					consumer = session.createConsumer(destination);
					final EventMessageListener eventMessageListener = (EventMessageListener) container
							.getComponentInstance("eventMessageListener");
					consumer.setMessageListener(eventMessageListener);
					bundleContext = FrameworkUtil.getBundle(consumer.getClass()).getBundleContext();
					final Dictionary<String, String> properties = new Hashtable<String, String>();
					properties.put(queueName, queueName);
					bundleContext.registerService(consumer.getClass().getName(), consumer, properties);
				}
			}
		}
		System.out.println("Created the listeners for all the Flows");
	}

	public SubscriberConfigurationRepository getSubscriberConfigurationRepository() {
		return subscriberConfigurationRepository;
	}

	public void setSubscriberConfigurationRepository(
			final SubscriberConfigurationRepository subscriberConfigurationRepository) {
		this.subscriberConfigurationRepository = subscriberConfigurationRepository;
	}

	public ConfigurationRepository getConfigurationRepository() {
		return configurationRepository;
	}

	public void setConfigurationRepository(final ConfigurationRepository configurationRepository) {
		this.configurationRepository = configurationRepository;
	}

	public BlueprintContainer getContainer() {
		return container;
	}

	public void setContainer(final BlueprintContainer container) {
		this.container = container;
	}

	public int getAcknowlegmentMode(final AcknowledgmentMode acknowledmentMode) {
		switch (acknowledmentMode) {
		case AUTO_ACKNOWLEDGE:
			return 1;
		case CLIENT_ACKNOWLEDGE:
			return 2;
		case DUPS_OK_ACKNOWLEDGE:
			return 3;
		case SESSION_TRANSACTED:
			return 0;
		default:
			return 1;
		}
	}

}
