package com.tmessinis.graph.constraint.factory;

import com.tmessinis.graph.contstraint.Constraint;

public interface ConstraintFactory {

	/**
	 * Return constraint from String.
	 * 
	 * @param constraintDescription
	 * 
	 * @return Constraint
	 * 
	 */
	Constraint parseConstraint(String constraintDescription);

}
