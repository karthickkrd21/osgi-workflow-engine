package com.scb.event.repository.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.apache.commons.collections.CollectionUtils;

import com.scb.event.model.RetryConfiguration;
import com.scb.event.model.id.RetryConfigurationKey;
import com.scb.event.repository.RetryConfigurationRepository;
import com.scb.wb.generic.repository.impl.GenericCrudRepositoryImpl;

public class RetryConfigurationRepositoryImpl extends
		GenericCrudRepositoryImpl<RetryConfiguration, RetryConfigurationKey> implements RetryConfigurationRepository {

	private EntityManager entityManager;

	@Override
	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(final EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public Iterable<String> findByFlowId(final String flowId) {
		final List<String> keys = new ArrayList<String>();
		final TypedQuery<RetryConfiguration> query = entityManager.createNamedQuery(RetryConfiguration.RETRY_CONFIGURATION_FIND_BY_FLOW_ID,
				RetryConfiguration.class);
		query.setParameter("flowId", flowId);
		final List<RetryConfiguration> retryConfigurations = query.getResultList();
		if (CollectionUtils.isNotEmpty(retryConfigurations)) {
			for (final RetryConfiguration retryConfiguration : retryConfigurations) {
				if (retryConfiguration.getKey() != null)
					keys.add(retryConfiguration.getKey().getFlowId());
			}
		}
		return keys;
	}

	public void init() {
		System.out.println("Inside Retry Configuration Init");
		final List<String> flowIds = (List<String>) this.findByFlowId("DEAL");
		for (final String flowId : flowIds) {
			System.out.println("Flow ID: " + flowId);
		}

	}

}
