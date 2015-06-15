package com.scb.event.workflow.action;

import com.scb.event.workflow.model.ProcessContext;

public interface ActionInvocator {

	public <S, T> S invokeAction(ProcessContext context, T Payload);
}
