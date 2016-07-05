package com.tmessinis.graph.constraint;

import com.tmessinis.graph.element.PathStats;

public class ConstraintImpl implements Constraint {

	private Type type;

	private Operator operator;

	private double cValue;

	public ConstraintImpl(Type type, Operator operator, double cValue) {
		super();
		this.type = type;
		this.operator = operator;
		this.cValue = cValue;
	}

	/**
	 * Constructor
	 */
	public ConstraintImpl() {
		super();
	}

	/** Evaluate */
	@Override
	public Boolean evaluate(double value) {
		return Evaluator.run(operator, value, cValue);
	}

	/** Evaluate path stats */
	@Override
	public Boolean evaluate(PathStats pathStats) {
		Boolean returnValue = false;
		if (type == Type.STOPS) {
			returnValue = Evaluator.run(operator, pathStats.getStops(), cValue);
		} else if (type == Type.DISTANCE) {
			returnValue = Evaluator.run(operator, pathStats.getDistance(), cValue);
		}
		return returnValue;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Operator getOperator() {
		return operator;
	}

	public void setOperator(Operator operator) {
		this.operator = operator;
	}

	@Override
	public void setcValue(int value) {
		this.cValue = value;

	}

	@Override
	public int getcValue() {
		return (int) cValue;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(cValue);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((operator == null) ? 0 : operator.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ConstraintImpl other = (ConstraintImpl) obj;
		if (Double.doubleToLongBits(cValue) != Double.doubleToLongBits(other.cValue))
			return false;
		if (operator != other.operator)
			return false;
		if (type != other.type)
			return false;
		return true;
	}
}
