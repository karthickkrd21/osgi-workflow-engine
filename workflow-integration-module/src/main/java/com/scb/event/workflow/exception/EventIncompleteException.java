package com.scb.event.workflow.exception;

public class EventIncompleteException extends Exception {

	private static final long serialVersionUID = -6764959983132144780L;

	public EventIncompleteException(final String msg) {
		super(msg);
	}

	public EventIncompleteException(final String msg, final Throwable e) {
		super(msg, e);
	}
}
