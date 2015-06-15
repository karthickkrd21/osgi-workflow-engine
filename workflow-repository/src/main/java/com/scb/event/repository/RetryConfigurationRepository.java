package com.scb.event.repository;

import com.scb.event.model.RetryConfiguration;
import com.scb.event.model.id.RetryConfigurationKey;
import com.scb.wb.generic.repository.GenericCrudRepository;

public interface RetryConfigurationRepository extends GenericCrudRepository<RetryConfiguration, RetryConfigurationKey> {

	public Iterable<String> findByFlowId(String flowId);
}
