package com.scb.event.workflow.action;

public interface Transformer<S, T> {

	public T transform(S payload);
}
