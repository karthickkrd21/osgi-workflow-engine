package com.scb.event.batch.repository.impl;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.scb.event.batch.model.BatchJobConfiguration;
import com.scb.event.batch.model.BatchJobParam;
import com.scb.event.batch.model.RouteConfiguration;
import com.scb.event.batch.repository.JobConfigurationRepository;
import com.scb.wb.generic.repository.impl.GenericCrudRepositoryImpl;

public class JobConfigurationRepositoryImpl extends GenericCrudRepositoryImpl<BatchJobConfiguration, BigInteger>
		implements JobConfigurationRepository {

	private EntityManager entityManager;

	public void setEntityManager(final EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public EntityManager getEntityManager() {
		return entityManager;
	}

	/**
	 * This method is used to get all the Batch Job Configurations
	 */
	public Iterable<BatchJobConfiguration> findAllJobConfiguration() {
		final TypedQuery<BatchJobConfiguration> query = entityManager.createNamedQuery(
				BatchJobConfiguration.FIND_ALL_BATCH_JOB_CONFIGURATION, BatchJobConfiguration.class);
		return query.getResultList();
	}

	public void init() {
		System.out.println("Inside Job Configuration Repository");
		final List<BatchJobConfiguration> batchJobConfigurations = (List<BatchJobConfiguration>) this
				.findAllJobConfiguration();
		for (final BatchJobConfiguration batchJobConfiguration : batchJobConfigurations) {
			System.out.println("Batch Job Configuration - group name" + batchJobConfiguration.getGroupName());
			for (final BatchJobParam batchJobParam : batchJobConfiguration.getParameters()) {
				System.out.println("Batch Job Parameters : parameter value: " + batchJobParam.getJobParamValue());
			}
			for (final RouteConfiguration routeConfiguration : batchJobConfiguration.getRoutes()) {
				System.out.println("Route Configuration : endpoint url" + routeConfiguration.getEndPointUri());
			}
		}

		System.out.println(" Job Configuration repository finished");

	}
}
