package com.scb.event.repository;

import com.scb.event.model.EventRuleMap;
import com.scb.event.model.id.EventRuleMapKey;
import com.scb.wb.generic.repository.GenericCrudRepository;

public interface RuleConfigurationRepository extends GenericCrudRepository<EventRuleMap, EventRuleMapKey> {

/*	@Cacheable("eventRuleMap")
	@Query("select e from EventRuleMap e where e.key.flowId = ?1")*/
	public Iterable<EventRuleMap> findByFlowId(String flowId);
}
