package com.scb.event.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.apache.commons.collections.CollectionUtils;

import com.scb.event.model.EventFlow;
import com.scb.event.repository.ConfigurationRepository;
import com.scb.wb.generic.repository.impl.GenericCrudRepositoryImpl;

public class ConfigurationRepositoryImpl extends GenericCrudRepositoryImpl<EventFlow, String> implements
		ConfigurationRepository {

	private EntityManager entityManager;

	public EventFlow findByFlowId(final String flowId) {
		System.out.println("Test By Flow Id in Confiuration Repository ");
		final TypedQuery<EventFlow> query = entityManager.createNamedQuery(EventFlow.EVENT_FLOW_FIND_BY_FLOW_ID,
				EventFlow.class);
		query.setParameter("flowId", flowId);
		final List<EventFlow> eventFlows = query.getResultList();
		if (CollectionUtils.isNotEmpty(eventFlows)) {
			return eventFlows.get(0);
		}
		return null;
	}

	public Iterable<EventFlow> findBySourceNodeId(final String sourceNodeId) {
		System.out.println("Test By Source Node Id in Configuration Repository");
		final TypedQuery<EventFlow> query = entityManager.createNamedQuery(EventFlow.FIND_BY_SOURCE_NODE_ID,
				EventFlow.class);
		query.setParameter("sourceNodeId", sourceNodeId);
		return query.getResultList();
	}

	@Override
	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(final EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void init() {
		System.out.println("Inside the init method of Configuration Repository");
		final EventFlow eventFlow = findByFlowId("DEAL_PERSISTENCE_FLOW");
		System.out.println("Event Flow: target node id: " + eventFlow.getTargetNode().getId());
		final List<EventFlow> eventFlow1 = (List<EventFlow>) findBySourceNodeId("N001");
		for (final EventFlow eventflow : eventFlow1) {
			System.out.println(" Event Flow Description inside for loop: flow id: " + eventflow.getId());
		}
	}

}
