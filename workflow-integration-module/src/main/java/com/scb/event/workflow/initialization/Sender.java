package com.scb.event.workflow.initialization;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class Sender {

	private ConnectionFactory factory = null;
	private Connection connection = null;
	private Session session = null;
	private Destination destination = null;
	private MessageProducer producer = null;

	public Sender() {
	}

	public void sendMessage() throws InterruptedException {
		try {
			factory = new ActiveMQConnectionFactory("admin", "admin", "tcp://localhost:61616");
			connection = factory.createConnection();
			connection.start();
			session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			destination = session.createQueue("StaticQueue_DEAL_ENTITLEMENT_FLOW");
			producer = session.createProducer(destination);
			System.out.println("After creating the destination");
			final TextMessage message = session.createTextMessage();
			message.setText("Hello ...This is a sample message..sending from1111111");
			producer.send(message);
			System.out.println("Sent: " + message.getText());
		} catch (final JMSException e) {
			e.printStackTrace();
		}
	}

	public static void main(final String args[]) {
		final Sender sender = new Sender();
		try {
			sender.sendMessage();
		} catch (final InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
