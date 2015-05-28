package com.scb.event.message.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.scb.event.message.model.EventMessageFork;
import com.scb.event.message.model.ExecutionStatus;
import com.scb.event.message.model.id.EventMessageForkKey;
import com.scb.event.message.repository.MessageForkRepository;
import com.scb.wb.generic.repository.impl.GenericCrudRepositoryImpl;

/**
 * 
 * This Class is used for all the CRUD functionality of MessageForkRepository *
 */
public class MessageForkRepositoryImpl extends GenericCrudRepositoryImpl<EventMessageFork, EventMessageForkKey>
		implements MessageForkRepository {

	private EntityManager entityManager;

	public void setEntityManager(final EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public EntityManager getEntityManager() {
		return entityManager;
	}

	@Override
	public Iterable<EventMessageFork> findByExecutionStatus(final ExecutionStatus executionStatus) {
		System.out.println("Inside findBy Execution Status");
		final TypedQuery<EventMessageFork> query = entityManager.createNamedQuery(
				EventMessageFork.FIND_BY_EXECUTION_STATUS, EventMessageFork.class);
		query.setParameter("executionStatus", executionStatus);
		return query.getResultList();
	}

	public void init() {
		System.out.println("Init Method inside Message Fork Repository Impl");
		final List<EventMessageFork> eventMessageForks = (List<EventMessageFork>) this
				.findByExecutionStatus(ExecutionStatus.PENDING);
		for (final EventMessageFork eventMessageFork : eventMessageForks) {
			System.out.println("EventMessageFork:  event retry count: " + eventMessageFork.getRetryCount());
		}
	}

}
