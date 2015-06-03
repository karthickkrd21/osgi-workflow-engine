package com.scb.framework.rule.expression;

import com.scb.framework.rule.model.ExpressionResolverType;
import com.scb.framework.rule.model.RuleExecutionStatus;

public interface RuleEngine {

	<T> RuleExecutionStatus evaluateRules(String flowId, T payload, ExpressionResolverType resolverType);
}
