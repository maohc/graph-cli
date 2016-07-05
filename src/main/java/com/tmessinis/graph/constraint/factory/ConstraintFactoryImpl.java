package com.tmessinis.graph.constraint.factory;

import com.tmessinis.graph.constraint.Type;
import com.tmessinis.graph.contstraint.Constraint;
import com.tmessinis.graph.contstraint.ConstraintImpl;
import com.tmessinis.graph.contstraint.Operator;

/**
 * Parse Constraint from Command Line [DISTANCE, STOPS] [GREATER_THAN,
 * GREATER_EQUAL_THAN, LESS_THAN, LESS_EQUAL_THAN] [VALUE] e.g. DISTANCE < 3
 */
public class ConstraintFactoryImpl implements ConstraintFactory {

	@Override
	public Constraint parseConstraint(String constraintDescription) {

		Constraint constraint = new ConstraintImpl();

		/**
		 * We break down constraint creation into step.
		 * 
		 * constraintManually.setType(Type.STOPS);
		 * constraintManually.setOperator(Operator.LESS_THAN);
		 * constraintManually.setcValue(3.0);
		 */

		String[] tokens = constraintDescription.split(" ");

		if (tokens.length == 3) {
			/** Set the type */
			if (tokens[0].contains(Type.STOPS.name())) {
				constraint.setType(Type.STOPS);
			} else if (tokens[0].contains(Type.DISTANCE.name())) {
				constraint.setType(Type.DISTANCE);
			}

			/** Set the operator */
			if (tokens[1].contains(Operator.LESS_EQUAL_THAN.toString())) {
				constraint.setOperator(Operator.LESS_EQUAL_THAN);
			} else if (tokens[1].contains(Operator.LESS_THAN.toString())) {
				constraint.setOperator(Operator.LESS_THAN);
			} else if (tokens[1].contains(Operator.EQUAL.toString())) {
				constraint.setOperator(Operator.EQUAL);
			}

			/** Set the constraintValue */
			int value = Integer.parseInt(tokens[2]);
			constraint.setcValue(value);
		}

		return constraint;
	}

}
