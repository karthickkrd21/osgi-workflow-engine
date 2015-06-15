package com.scb.event.workflow.action;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.hamcrest.internal.ArrayIterator;
import org.osgi.service.blueprint.container.BlueprintContainer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.scb.event.workflow.action.concurrent.ExecuteActionTask;
import com.scb.event.workflow.exception.EventIncompleteException;
import com.scb.event.workflow.model.ProcessContext;

public class ActionInvocatorImpl implements ActionInvocator {

	private final Logger logger = LoggerFactory.getLogger(ActionInvocatorImpl.class);

	private BlueprintContainer container;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public <S, T> S invokeAction(final ProcessContext context, final T payload) {
		Action action = null;
		if (context.getActionId() != null) {
			action = (Action) container.getComponentInstance(context.getActionId());
			if (context.getChunkProcessingEnabled() && payload.getClass().isArray()) {
				return (S) processItems(context, action, payload);
			}
			return (S) action.execute(context, payload);
		}
		return null;
	}

	/**
	 * Method to process the Payload as Chunk Item to enable concurrent processing of the Payload.
	 * 
	 * @param context
	 *            The {@link ProcessContext}
	 * @param action
	 *            The {@link Action}
	 * @param payload
	 *            The Payload
	 * @return
	 * @throws EventIncompleteException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public <S, T> S processItems(final ProcessContext context, final Action action, final T payload) {
		final Iterator iterator = new ArrayIterator(payload);
		boolean hasError = false;
		Throwable throwable = null;
		final List results = new ArrayList();
		final List<Future<Object>> futures = new ArrayList<Future<Object>>();
		while (iterator.hasNext()) {
			final ExecuteActionTask executeActionTask = (ExecuteActionTask) container
					.getComponentInstance("executionActionTask");
			executeActionTask.setAction(action);
			executeActionTask.setContext(context);
			executeActionTask.setPayload(iterator.next());
			futures.add(getThreadPoolExecutor().submit(executeActionTask));
		}
		Class resultType = null;
		for (final Future<Object> future : futures) {
			try {
				final Object item = future.get();
				if (resultType == null) {
					resultType = getType(item);
				}
				addItem(results, item);
			} catch (final Exception e) {
				logger.error("Event Execution could not be completed", e);
				hasError = true;
				throwable = e;
			}
		}
		if (hasError)
			try {
				throw new EventIncompleteException("Incomplete Event Execution", throwable);
			} catch (final EventIncompleteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return (S) results.toArray((Object[]) Array.newInstance(resultType, results.size()));
	}

	@SuppressWarnings("rawtypes")
	private Class getType(final Object item) {
		return item.getClass().isArray() ? item.getClass().getComponentType() : item.getClass();

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void addItem(final List results, final Object result) {
		if (result.getClass().isArray()) {
			final Iterator resultIterator = new ArrayIterator(result);
			while (resultIterator.hasNext()) {
				results.add(resultIterator.next());
			}
		} else {
			results.add(result);
		}

	}

	public BlueprintContainer getContainer() {
		return container;
	}

	public void setContainer(final BlueprintContainer container) {
		this.container = container;
	}

	public ThreadPoolExecutor getThreadPoolExecutor() {
		return new ThreadPoolExecutor(2, 4, 10, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(2));
	}

}
