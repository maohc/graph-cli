package com.tmessinis.graph.constraint;

public enum Operator {
	EQUAL("=") {
		@Override
		public boolean apply(double x1, double x2) {
			return x1 <= x2;
		}
	},
	LESS_THAN("<") {
		@Override
		public boolean apply(double x1, double x2) {
			return x1 < x2;
		}
	},
	LESS_EQUAL_THAN("<=") {
		@Override
		public boolean apply(double x1, double x2) {
			return x1 <= x2;
		}
	};

	private final String text;

	private Operator(String text) {
		this.text = text;
	}

	public abstract boolean apply(double x1, double x2);

	@Override
	public String toString() {
		return text;
	}

}
