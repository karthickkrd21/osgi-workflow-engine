package com.scb.framework.rule.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class DealPipelineEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	private String salesStage;
	private String productGroup;

	private MasterEntity masterEntity;

	public String getSalesStage() {
		return salesStage;
	}

	public void setSalesStage(String salesStage) {
		this.salesStage = salesStage;
	}
	
	public String getProductGroup() {
		return productGroup;
	}
	
	public void setProductGroup(String productGroup) {
		this.productGroup = productGroup;
	}

	public DealPipelineEntity() {
		this.masterEntity = new MasterEntity();
	}

	public MasterEntity getMasterEntity() {
		return masterEntity;
	}

	public void setMasterEntity(MasterEntity masterEntity) {
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

		public void setId(BigDecimal id) {
			this.id = id;
		}

		public void setModifiedEntities(Set<String> modifiedEntities) {
			this.modifiedEntities = modifiedEntities;
		}

	}
}
