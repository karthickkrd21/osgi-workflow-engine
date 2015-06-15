package com.scb.event.workflow.util;

import java.io.PrintWriter;
import java.io.StringWriter;

import com.scb.event.workflow.model.EventContext;

public class DefaultErrorHandler {

	public String handleError(final EventContext context) {
		if (context.getError() != null) {
			final StringWriter writer = new StringWriter();
			final PrintWriter printWriter = new PrintWriter(writer);
			context.getError().printStackTrace(printWriter);
			return writer.toString();
		}
		return null;
	}
}
