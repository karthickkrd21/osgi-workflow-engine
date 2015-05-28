package com.scb.event.repository;

import com.scb.event.model.EventFlow;
import com.scb.wb.generic.repository.GenericCrudRepository;

public interface ConfigurationRepository extends GenericCrudRepository<EventFlow, String> {

	
	/*@Cacheable("eventFlow")*/
	public EventFlow findByFlowId(String flowId);

/*	@Override
	@Cacheable("eventFlow")
	public Iterable<EventFlow> findAll();*/

	/*@Cacheable("eventFlow")*/
	public Iterable<EventFlow> findBySourceNodeId(String sourceNodeId);
}
