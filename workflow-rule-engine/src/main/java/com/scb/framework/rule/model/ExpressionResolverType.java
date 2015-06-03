package com.scb.framework.rule.model;

public enum ExpressionResolverType{
SPEL("SPEL") , MVEL("MVEL");

String resolverType;

private ExpressionResolverType(String resolverType) {
	this.resolverType = resolverType;
}

public String getResolverType() {
	return resolverType;
}

public void setResolverType(String resolverType) {
	this.resolverType = resolverType;
}

}
