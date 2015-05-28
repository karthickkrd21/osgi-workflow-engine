package com.scb.event.batch.repository;

import java.math.BigInteger;

import com.scb.event.batch.model.BatchJobConfiguration;
import com.scb.wb.generic.repository.GenericCrudRepository;

public interface JobConfigurationRepository extends GenericCrudRepository<BatchJobConfiguration, BigInteger> {

	/**
	 * This method is used to get all the Batch Job Configurations
	 * 
	 * @return
	 */
	public Iterable<BatchJobConfiguration> findAllJobConfiguration();
}
