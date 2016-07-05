package com.tmessinis.graph.constraint.factory;

import com.tmessinis.graph.constraint.Constraint;

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
