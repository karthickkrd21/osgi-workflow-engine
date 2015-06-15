package com.scb.event.repository;

import com.scb.event.model.SubscriberConfiguration;
import com.scb.wb.generic.repository.GenericCrudRepository;

public interface SubscriberConfigurationRepository extends GenericCrudRepository<SubscriberConfiguration, String> {

	public Iterable<SubscriberConfiguration> findAll() throws ClassNotFoundException;
}