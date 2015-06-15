package com.scb.event.workflow.action;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import com.scb.event.workflow.model.ProcessContext;
import com.scb.onewb.sp.dealpipeline.model.DealPipelineEntity;
import com.scb.onewb.sp.dealpipeline.model.DealPipelineEntity.MasterEntity;

public class DefaultActionImpl implements Action<Object, Object> {

	@Override
	public Object execute(final ProcessContext context, final Object payload) {
		System.out.println("Inside DefaultActionImpl");
		final DealPipelineEntity dealPipelineEntity = new DealPipelineEntity();
		dealPipelineEntity.setProductGroup("CF");
		dealPipelineEntity.setSalesStage("dummySalesStage");
		final MasterEntity masterEntity = new MasterEntity();
		masterEntity.setId(BigDecimal.ONE);
		final Set<String> modifiedEntities = new HashSet<String>();
		modifiedEntities.add("TEST");
		masterEntity.setModifiedEntities(modifiedEntities);
		dealPipelineEntity.setMasterEntity(masterEntity);
		return dealPipelineEntity;
	}

}
