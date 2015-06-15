package com.scb.event.workflow.publisher;

import java.util.Calendar;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;

import com.scb.event.message.model.EventMessageFork;
import com.scb.event.message.model.ExecutionStatus;
import com.scb.event.message.repository.MessageForkRepository;
import com.scb.event.model.AcknowledgmentMode;
import com.scb.event.model.FlowCategory;
import com.scb.event.model.SubscriberConfiguration;
import com.scb.event.repository.SubscriberConfigurationRepository;

public class EventMessagePublisher {

	private MessageForkRepository messageForkRepository;
	private SubscriberConfigurationRepository subscriberConfigurationRepository;
	private SubscriberConfiguration subscriberConfiguration;
	private Connection connection;

	private Session session = null;
	private Destination destination = null;
	private MessageProducer producer = null;

	public Connection getConnection() {
		return connection;
	}

	public void init() {
		System.out.println("Inside the Init method of eventPublisher");
		try {
			subscriberConfiguration = subscriberConfigurationRepository.fetch("EventFlow_InternalSubscriber");
			final ConnectionFactory factory = new ActiveMQConnectionFactory(subscriberConfiguration.getUsername(),
					subscriberConfiguration.getPassword(), subscriberConfiguration.getProviderUrl());
			connection = factory.createConnection();
			connection.start();
		} catch (final Exception e) {
			System.out.println("Exception in creating the Connection Factory object");
			e.printStackTrace();
		}
	}

	public void publish(final EventMessageFork fork) {
		try {
			final SubscriberConfiguration subscriberConfiguration = subscriberConfigurationRepository
					.fetch("EventFlow_InternalSubscriber");
			if (fork.getEventFlow() != null && fork.getEventFlow().getFlowCategory() != null
					&& FlowCategory.ONLINE == fork.getEventFlow().getFlowCategory()) {
				if (subscriberConfiguration != null) {
					System.out.println("Subscriber Configuration is not null");
					session = connection.createSession(subscriberConfiguration.getSessionTransacted(),
							getAcknowlegmentMode(subscriberConfiguration.getAcknowledgmentMode()));
					destination = session.createQueue("StaticQueue_" + fork.getEventFlow().getId());
					producer = session.createProducer(destination);
					final Message message = session.createObjectMessage(fork);
					producer.send(message);
					System.out.println("Message has been sent from the publisher");
				}
			}
		} catch (final Exception e) {
			System.out.println("Exception in publishing the message");
			e.printStackTrace();
		}
		fork.setExecutionStatus(ExecutionStatus.PUBLISHED);
		fork.setUpdatedOn(Calendar.getInstance().getTime());
		this.messageForkRepository.save(fork);
	}

	public void publish(final EventMessageFork fork, final String destinationName) {
		if (fork.getEventFlow() != null && fork.getEventFlow().getFlowCategory() != null
				&& FlowCategory.ONLINE == fork.getEventFlow().getFlowCategory()) {
			SubscriberConfiguration subscriberConfiguration;
			try {
				subscriberConfiguration = subscriberConfigurationRepository.fetch("EventFlow_InternalSubscriber");
				if (subscriberConfiguration != null) {
					System.out.println("Subscriber Configuration is not null");
					session = connection.createSession(subscriberConfiguration.getSessionTransacted(),
							getAcknowlegmentMode(subscriberConfiguration.getAcknowledgmentMode()));
					destination = session.createQueue("StaticQueue_" + destinationName);
					producer = session.createProducer(destination);
					final Message message = session.createObjectMessage(fork);
					producer.send(message);
					System.out.println("Message has been sent from the publisher");
				}
			} catch (final Exception e) {
				System.out.println("Exception in publishing the message");
				e.printStackTrace();
			}

		}
		fork.setExecutionStatus(ExecutionStatus.PUBLISHED);
		fork.setUpdatedOn(Calendar.getInstance().getTime());
		this.messageForkRepository.save(fork);
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

	public MessageForkRepository getMessageForkRepository() {
		return messageForkRepository;
	}

	public void setMessageForkRepository(final MessageForkRepository messageForkRepository) {
		this.messageForkRepository = messageForkRepository;
	}

	public SubscriberConfigurationRepository getSubscriberConfigurationRepository() {
		return subscriberConfigurationRepository;
	}

	public void setSubscriberConfigurationRepository(
			final SubscriberConfigurationRepository subscriberConfigurationRepository) {
		this.subscriberConfigurationRepository = subscriberConfigurationRepository;
	}

}
