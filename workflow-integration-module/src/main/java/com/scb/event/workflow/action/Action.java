package com.scb.event.workflow.action;

import com.scb.event.workflow.model.ProcessContext;

public interface Action<T, S> {

	public S execute(ProcessContext context, T payload);
}
