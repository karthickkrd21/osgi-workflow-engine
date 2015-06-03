package com.scb.framework.rule.expression.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.mvel2.MVEL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import com.scb.event.model.EventRuleMap;
import com.scb.event.repository.RuleConfigurationRepository;
import com.scb.framework.rule.expression.RuleEngine;
import com.scb.framework.rule.model.ExpressionResolverType;
import com.scb.framework.rule.model.RuleExecutionStatus;

/**
 * Class will evaluate the rule expression. Currently supports two implementations SPEL and MVEL
 * 
 * @author Akshay
 * 
 */
public class RuleEngineImpl implements RuleEngine {

	private static final Logger logger = LoggerFactory.getLogger(RuleEngineImpl.class);

	private RuleConfigurationRepository ruleConfigurationRepository;

	private final ExpressionParser spelExpressionParser = new SpelExpressionParser();

	private Expression exp;

	/**
	 * Method will accept a flow id and will retrieve the rule expressions for this flow id Depending upon the resolver
	 * type (SPEL or MVEL) it will use the respective expression resolver
	 */
	@Override
	public <T> RuleExecutionStatus evaluateRules(final String flowId, final T payload,
			final ExpressionResolverType resolverType) {
		System.out.println("Inside Rule Execution Status");
		RuleExecutionStatus ruleExecutionStatus = RuleExecutionStatus.UNFIT;
		if (StringUtils.isNotEmpty(flowId)) {
			System.out.println("Inside Rule Configuration Repository: " + ruleConfigurationRepository);
			final Iterable<EventRuleMap> ruleMap = ruleConfigurationRepository.findByFlowId(flowId);
			boolean result = false;
			if (ruleMap != null) {
				final List<String> ruleExpressions = buildRuleExpression(ruleMap);
				if (ruleExpressions != null) {
					result = getRuleEvaluationResult(ruleExpressions, payload, resolverType);
					ruleExecutionStatus = result ? RuleExecutionStatus.SUCCESS : RuleExecutionStatus.UNFIT;
				}
			} else {
				return RuleExecutionStatus.SUCCESS;
			}
		}
		return ruleExecutionStatus;
	}

	private List<String> buildRuleExpression(final Iterable<EventRuleMap> rules) {
		final List<String> ruleExpressions = new ArrayList<String>();
		for (final EventRuleMap ruleMap : rules) {
			ruleExpressions.add(ruleMap.getEventRule().getExpression());
		}
		return ruleExpressions;
	}

	private boolean getRuleEvaluationResult(final List<String> ruleExpressions, final Object payload,
			final ExpressionResolverType resolverType) {
		boolean isParsedSuccessfully = false;
		for (final String expression : ruleExpressions) {
			try {
				isParsedSuccessfully = isParsedSuccessfully(expression, payload, resolverType);
				if (!isParsedSuccessfully)
					break;
			} catch (final Exception e) {
				logger.error("Rule Expression could not be parsed successfully", e);
			}
		}
		return isParsedSuccessfully;
	}

	private boolean isParsedSuccessfully(final String expression, final Object payload,
			final ExpressionResolverType resolverType) throws Exception {
		final boolean isParsedSuccessfully = false;
		if (ExpressionResolverType.SPEL == resolverType) {
			return useSpelParser(expression, payload);
		} else if (ExpressionResolverType.MVEL == resolverType) {
			return useMvelParser(expression, payload);
		}
		return isParsedSuccessfully;
	}

	private boolean useSpelParser(final String expression, final Object payload) {
		final Expression exp = spelExpressionParser.parseExpression(expression);
		return (Boolean) exp.getValue(payload);
	}

	private boolean useMvelParser(final String expression, final Object payload) throws Exception {
		return (Boolean) MVEL.eval(expression, payload);

	}

	public RuleConfigurationRepository getRuleConfigurationRepository() {
		return ruleConfigurationRepository;
	}

	public void setRuleConfigurationRepository(final RuleConfigurationRepository ruleConfigurationRepository) {
		this.ruleConfigurationRepository = ruleConfigurationRepository;
	}

}
