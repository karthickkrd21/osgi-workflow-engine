package com.scb.event.message.repository.impl;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import com.scb.event.message.model.EventMessage;
import com.scb.event.message.model.EventMessageAttribute;
import com.scb.event.message.model.id.EventMessageAttributeKey;
import com.scb.event.message.repository.MessageAttributeRepository;
import com.scb.event.model.EventBeanAttribute;
import com.scb.event.model.id.EventBeanAttributeKey;
import com.scb.wb.generic.repository.impl.GenericCrudRepositoryImpl;

/*
 * This class is used to do all the CRUD operations in Message Attribute
 */
public class MessageAttributeRepositoryImpl extends
		GenericCrudRepositoryImpl<EventMessageAttribute, EventMessageAttributeKey> implements
		MessageAttributeRepository {

	private EntityManager entityManager;

	public void setEntityManager(final EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void init() {
		System.out.println("Inside init method of MessageAttributeRepository ");
		final EventMessageAttribute eventMessageAttribute = new EventMessageAttribute();
		final EventMessageAttributeKey eventMessageAttributeKey = new EventMessageAttributeKey();
		eventMessageAttributeKey.setAttributeId("DEAL_ID");
		eventMessageAttributeKey.setBeanId("DEAL");
		eventMessageAttributeKey.setMessageId(BigDecimal.ONE);
		eventMessageAttribute.setEventMessageAttributeKey(eventMessageAttributeKey);
		final EventMessage eventMessage = new EventMessage();
		eventMessage.setMessageId(BigDecimal.ONE);
		eventMessageAttribute.setEventMessage(eventMessage);
		final EventBeanAttribute eventBeanAttribute = new EventBeanAttribute();
		final EventBeanAttributeKey eventBeanAttributeKey = new EventBeanAttributeKey();
		eventBeanAttributeKey.setBeanId("DEAL");
		eventBeanAttributeKey.setAttributeId("DEAL_ID");
		eventBeanAttribute.setEventBeanAttributeKey(eventBeanAttributeKey);
		eventMessageAttribute.setAttributeValue("test");
		eventMessageAttribute.setSequence(1);
		this.save(eventMessageAttribute);
		System.out.println("After save of Message Attribute Repository");
	}

}
