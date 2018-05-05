package com.raulexposito.model.game;

class Counter {

	// ------------------------------------------------------------------------
	// CONSTANT VALUES
	// ------------------------------------------------------------------------

	private static final Integer MAX_STEPS = 1000;
	private static final Integer MAX_ATTEMPTS = 20;

	// ------------------------------------------------------------------------
	// ATTRIBUTES
	// ------------------------------------------------------------------------

	private final Integer max;
	private final Integer value;

	// ------------------------------------------------------------------------
	// CONSTRUCTOR
	// ------------------------------------------------------------------------

	private Counter(Integer value, Integer max) {
		this.value = value;
		this.max = max;
	}

	// ------------------------------------------------------------------------
	// INITIALIZERS
	// ------------------------------------------------------------------------

	static Counter initSteps() {
		return new Counter(0, MAX_STEPS);
	}

	static Counter initAttempts() {
		return new Counter(0, MAX_ATTEMPTS);
	}

	// ------------------------------------------------------------------------
	// BUSINESS LOGIC
	// ------------------------------------------------------------------------

	Counter increase() {
		return new Counter(value + 1, max);
	}

	boolean maxReached() {
		return value.equals(max);
	}
}
