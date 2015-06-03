package com.scb.event.message.repository.impl;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import com.scb.event.message.model.InterfaceMessage;
import com.scb.event.message.repository.InterfaceMessageRepository;
import com.scb.wb.generic.repository.impl.GenericCrudRepositoryImpl;

/**
 * 
 * This class is used to save and retrieve the Interface Message Entity.
 * 
 * @author Karthick
 * 
 */
public class InterfaceMessageRepositoryImpl extends GenericCrudRepositoryImpl<InterfaceMessage, BigDecimal> implements
		InterfaceMessageRepository {

	private EntityManager entityManager;

	public void setEntityManager(final EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void init() {
		System.out.println("Inside the init method of Interface Message Repository");
		/*
		 * final InterfaceMessage interfaceMessage = new InterfaceMessage(); interfaceMessage.setId(new
		 * BigDecimal("1011")); interfaceMessage.setCaptureSystem("capture"); interfaceMessage.setCorrelationId("test");
		 * interfaceMessage.setPayload("payload sample"); this.save(interfaceMessage);
		 */
		System.out.println("Save of Init Message Repository done...");
	}

}
