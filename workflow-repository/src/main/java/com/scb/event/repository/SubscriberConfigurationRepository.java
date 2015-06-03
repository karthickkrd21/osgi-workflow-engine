package com.scb.event.repository;

import com.scb.event.model.SubscriberConfiguration;
import com.scb.wb.generic.repository.GenericCrudRepository;

public interface SubscriberConfigurationRepository extends GenericCrudRepository<SubscriberConfiguration, String> {

	/*@Override
	@Cacheable("subscriberConfiguration")*/
	public Iterable<SubscriberConfiguration> findAll();
}