package com.raulexposito.model.game;

public class Counter {

	// ------------------------------------------------------------------------
	// CONSTANTS
	// ------------------------------------------------------------------------

	private static final Integer INIT = 0;

	// ------------------------------------------------------------------------
	// ATTRIBUTES
	// ------------------------------------------------------------------------

	private final Integer limit;
	private final Integer value;

	// ------------------------------------------------------------------------
	// CONSTRUCTOR
	// ------------------------------------------------------------------------

	private Counter(Integer value, Integer limit) {
		this.value = value;
		this.limit = limit;
	}

	public static Counter upTo(Integer limit) {
		return new Counter(INIT, limit);
	}

	// ------------------------------------------------------------------------
	// BUSINESS LOGIC
	// ------------------------------------------------------------------------

	public Counter increase() {
		return new Counter(value + 1, limit);
	}

	public boolean limitReached() {
		return value >= limit;
	}

	public Counter reset() {
		return upTo(limit);
	}
}
