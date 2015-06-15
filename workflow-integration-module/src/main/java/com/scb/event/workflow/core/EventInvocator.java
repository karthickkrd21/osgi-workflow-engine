package com.scb.event.workflow.core;

import com.scb.event.workflow.model.EventContext;
import com.scb.event.workflow.model.ProcessContext;

public interface EventInvocator {

	public <T, S> S invoke(ProcessContext context, T payload);

	public <T, S> S invoke(EventContext context, T payload);
}
