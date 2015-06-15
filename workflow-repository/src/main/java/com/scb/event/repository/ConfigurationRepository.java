package com.scb.event.repository;

import java.util.List;

import com.scb.event.model.EventFlow;
import com.scb.wb.generic.repository.GenericCrudRepository;

public interface ConfigurationRepository extends GenericCrudRepository<EventFlow, String> {

	public EventFlow findByFlowId(String flowId);

	public Iterable<EventFlow> findBySourceNodeId(String sourceNodeId);

	public List<String> findAllNotEmptySourceNodes();
}
