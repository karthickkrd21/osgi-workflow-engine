package com.scb.event.workflow.core;

import com.scb.event.message.model.ExecutionStatus;
import com.scb.event.model.EventFlow;
import com.scb.event.workflow.action.ActionInvocator;
import com.scb.event.workflow.model.EventContext;
import com.scb.framework.rule.expression.RuleEngine;
import com.scb.framework.rule.model.ExpressionResolverType;
import com.scb.framework.rule.model.RuleExecutionStatus;

public class EventProcessorImpl implements EventProcessor {

	private RuleEngine ruleEngine;

	private ActionInvocator actionInvocator;

	@Override
	@SuppressWarnings({ "unchecked" })
	public <S, T> S execute(final EventContext context, final T payload) {
		S response = null;
		if (context.getEventFlow() != null && context.getEventFlow().getAction() != null) {
			final ExecutionStatus status = evaluateRules(context.getEventFlow(), payload);
			if (ExecutionStatus.SUCCESS == status) {
				context.getProcessContext().setActionId(context.getEventFlow().getAction().getId());
				response = (S) actionInvocator.invokeAction(context.getProcessContext(), payload);
			}
		}
		return response;
	}

	private <T> ExecutionStatus evaluateRules(final EventFlow eventFlow, final T payload) {
		ExecutionStatus status = null;
		final RuleExecutionStatus ruleExecutionStatus = ruleEngine.evaluateRules(eventFlow.getId(), payload,
				ExpressionResolverType.SPEL);
		if (RuleExecutionStatus.SUCCESS == ruleExecutionStatus) {
			return ExecutionStatus.SUCCESS;
		} else if (RuleExecutionStatus.UNFIT == ruleExecutionStatus) {
			if (eventFlow.getRetryEnabled() && eventFlow.getRuleEvaluationRetryEnabled()) {
				status = ExecutionStatus.PENDING;
			} else if (eventFlow.getRetryEnabled() && !eventFlow.getRuleEvaluationRetryEnabled()) {
				status = ExecutionStatus.UNFIT;
			}
		}
		return status;
	}

	public RuleEngine getRuleEngine() {
		return ruleEngine;
	}

	public void setRuleEngine(final RuleEngine ruleEngine) {
		this.ruleEngine = ruleEngine;
	}

	public ActionInvocator getActionInvocator() {
		return actionInvocator;
	}

	public void setActionInvocator(final ActionInvocator actionInvocator) {
		this.actionInvocator = actionInvocator;
	}

}
