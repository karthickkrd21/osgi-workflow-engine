package com.scb.event.workflow.core;

import com.scb.event.workflow.model.EventContext;

public interface EventProcessor {

	public <S, T> S execute(EventContext context, T payload);
}
