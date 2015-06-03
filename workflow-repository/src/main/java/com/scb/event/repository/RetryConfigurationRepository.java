package com.scb.event.repository;


import com.scb.event.model.RetryConfiguration;
import com.scb.event.model.id.RetryConfigurationKey;
import com.scb.wb.generic.repository.GenericCrudRepository;

public interface RetryConfigurationRepository extends GenericCrudRepository<RetryConfiguration, RetryConfigurationKey> {

	/*@Cacheable("retryConfiguration")
	@Query("select e.key.retryException from RetryConfiguration e where e.key.flowId = ?1")*/
	public Iterable<String> findByFlowId(String flowId);
}
