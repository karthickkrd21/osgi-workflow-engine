package com.scb.event.workflow.action.concurrent;

import java.util.concurrent.Callable;

import com.scb.event.workflow.action.Action;
import com.scb.event.workflow.model.ProcessContext;

/**
 * The Callable Task to be executed by the ThreadPoolTaskExecutor.
 * 
 * @author prabusivakumar
 * @version 1.0
 */
public interface ExecuteActionTask extends Callable<Object> {

	public void setPayload(Object payload);

	public void setAction(@SuppressWarnings("rawtypes") Action action);

	public void setContext(ProcessContext processContext);
}
