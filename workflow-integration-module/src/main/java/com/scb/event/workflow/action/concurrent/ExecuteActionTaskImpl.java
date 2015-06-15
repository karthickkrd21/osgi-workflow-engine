package com.scb.event.workflow.action.concurrent;

import com.scb.event.workflow.action.Action;
import com.scb.event.workflow.model.ProcessContext;

/**
 * Execute Action Implementation provides the implementation for the Execute Action Task.
 * 
 * @author prabusivakumar
 * @version 1.0
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
public class ExecuteActionTaskImpl implements ExecuteActionTask {

	private Object payload;
	private Action action;
	private ProcessContext processContext;

	@Override
	public Object call() throws Exception {
		return this.action.execute(processContext, payload);
	}

	@Override
	public void setPayload(final Object payload) {
		this.payload = payload;
	}

	@Override
	public void setAction(final Action action) {
		this.action = action;
	}

	@Override
	public void setContext(final ProcessContext processContext) {
		this.processContext = processContext;
	}

}