package com.tmessinis.graph.constraint;

public class ConstraintdUtil {

	/**
	 * Return the index of the constaint  
	 * 
	 * @param constraintString
	 * @return index
	 */
	public static int getIndexOfConstraint(String constraintString) {
		int index = 0;
		for (Type type : Type.values()) {
			if (constraintString.contains(type.name())) {
				index = constraintString.indexOf(type.name());
			}
		}
		return index;
	}
}
