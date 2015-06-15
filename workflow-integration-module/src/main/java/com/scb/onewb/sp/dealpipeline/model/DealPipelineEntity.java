package com.scb.onewb.sp.dealpipeline.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import com.scb.event.workflow.core.EventInvocator;
import com.scb.event.workflow.model.ProcessContext;

public class DealPipelineEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	private String salesStage;
	private String productGroup;

	private EventInvocator eventInvocator;

	public EventInvocator getEventInvocator() {
		return eventInvocator;
	}

	public void setEventInvocator(final EventInvocator eventInvocator) {
		this.eventInvocator = eventInvocator;
	}

	private MasterEntity masterEntity;

	public String getSalesStage() {
		return salesStage;
	}

	public void setSalesStage(final String salesStage) {
		this.salesStage = salesStage;
	}

	public String getProductGroup() {
		return productGroup;
	}

	public void setProductGroup(final String productGroup) {
		this.productGroup = productGroup;
	}

	public DealPipelineEntity() {
		this.masterEntity = new MasterEntity();
	}

	public MasterEntity getMasterEntity() {
		return masterEntity;
	}

	public void setMasterEntity(final MasterEntity masterEntity) {
		this.masterEntity = masterEntity;
	}

	public static class MasterEntity implements Serializable {

		private static final long serialVersionUID = 1L;
		private BigDecimal id;
		private Set<String> modifiedEntities = new HashSet<String>();

		public BigDecimal getId() {
			return id;
		}

		public Set<String> getModifiedEntities() {
			return modifiedEntities;
		}

		public void setId(final BigDecimal id) {
			this.id = id;
		}

		public void setModifiedEntities(final Set<String> modifiedEntities) {
			this.modifiedEntities = modifiedEntities;
		}

	}

	public void init() {
		// Method under test
		System.out.println("**** Entering the init Method of EventInvocator impl ");
		final ProcessContext context = new ProcessContext();
		context.setActionId("DEAL_PERSISTENCE_ACTION");
		context.setApplicationGroup("FAP");
		context.setChunkProcessingEnabled(Boolean.FALSE);
		context.setCountry("India");
		context.setEntity("DEAL");
		context.setFlowId("DEAL_PERSISTENCE_FLOW");
		context.setFunction("CF");
		context.setInstanceCode("123");
		context.setUserId("1297014");
		final DealPipelineEntity dealPipelineEntity = new DealPipelineEntity();
		dealPipelineEntity.setProductGroup("CF");
		dealPipelineEntity.setSalesStage("dummySalesStage");
		final MasterEntity masterEntity = new MasterEntity();
		masterEntity.setId(BigDecimal.ONE);
		final Set<String> modifiedEntities = new HashSet<String>();
		modifiedEntities.add("TEST");
		masterEntity.setModifiedEntities(modifiedEntities);
		dealPipelineEntity.setMasterEntity(masterEntity);
		eventInvocator.invoke(context, dealPipelineEntity);
		System.out.println("Exiting the init method of Event Invocator");
		System.out.println("Test Case Executed Successfully");
	}
}
