package com.tmessinis.graph.constraint;

public class Evaluator {

	/**
	 * Evaluate Operator
	 * 
	 * @param operator
	 * @param value
	 * @param constraint
	 * 
	 * @return true/false
	 */
	public static Boolean run(Operator operator, double value, double constraint) {
		return Boolean.valueOf(operator.apply(value, constraint));
	}

}
