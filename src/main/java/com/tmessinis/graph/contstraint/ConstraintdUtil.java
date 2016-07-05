package com.tmessinis.graph.contstraint;

import com.tmessinis.graph.constraint.Type;

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
