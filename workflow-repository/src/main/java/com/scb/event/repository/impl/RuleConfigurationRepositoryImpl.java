package com.scb.event.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.scb.event.model.EventRuleMap;
import com.scb.event.model.id.EventRuleMapKey;
import com.scb.event.repository.RuleConfigurationRepository;
import com.scb.wb.generic.repository.impl.GenericCrudRepositoryImpl;

public class RuleConfigurationRepositoryImpl extends GenericCrudRepositoryImpl<EventRuleMap, EventRuleMapKey> implements
		RuleConfigurationRepository {

	private EntityManager entityManager;

	@Override
	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(final EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public Iterable<EventRuleMap> findByFlowId(final String flowId) {
		System.out.println("Inside findBy Flow Id of Event Rule Map");
		final TypedQuery<EventRuleMap> query = entityManager.createNamedQuery(
				EventRuleMap.EVENT_RULE_MAP_FIND_BY_FLOW_ID, EventRuleMap.class);
		query.setParameter("flowId", flowId);
		return query.getResultList();
	}

	public void init() {
		System.out.println("Inside Init mehtod of Rule Configuration Repository");
		final List<EventRuleMap> eventRuleMaps = (List<EventRuleMap>) this.findByFlowId("DEAL_NOTIFICATION_FLOW");
		for (final EventRuleMap eventRuleMap : eventRuleMaps) {
			System.out.println("EventRuleMap.eventBean: " + eventRuleMap.getEventBean());
			System.out.println("EventRuleMap.eventRule: " + eventRuleMap.getEventRule());
			System.out.println("EventRuleMap.eventFlow: " + eventRuleMap.getEventFlow());
			System.out.println("EventRuleMap: flowId: " + eventRuleMap.getEventFlow().getId() + " beanId: "
					+ eventRuleMap.getEventBean().getId() + " Rule Id: " + eventRuleMap.getEventRule().getId());
		}

	}

}
