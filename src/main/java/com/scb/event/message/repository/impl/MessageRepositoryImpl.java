package com.scb.event.message.repository.impl;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import com.scb.event.message.model.EventMessage;
import com.scb.event.message.repository.MessageRepository;
import com.scb.wb.generic.repository.impl.GenericCrudRepositoryImpl;

/**
 * 
 * This class is used for all the CRUD operations in Message Repository
 * 
 */
public class MessageRepositoryImpl extends GenericCrudRepositoryImpl<EventMessage, BigDecimal> implements
		MessageRepository {

	private EntityManager entityManager;

	public void setEntityManager(final EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void init() {
		System.out.println("Inside init of Message Repository");
		/*
		 * final EventMessage eventMessage = new EventMessage(); eventMessage.setApplicationGroup("T1");
		 * eventMessage.setMessageId(new BigDecimal("2001")); eventMessage.setCountry("India");
		 * eventMessage.setEntity("entity"); eventMessage.setPayload("test payload type"); this.save(eventMessage);
		 */
		System.out.println("Event Message Saved Successfully");
	}
}
