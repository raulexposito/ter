package com.raulexposito.model.game.result;

import com.raulexposito.model.game.Steps;

public abstract class Result {

	// ------------------------------------------------------------------------
	// ATTRIBUTES
	// ------------------------------------------------------------------------

	private final Steps steps;

	// ------------------------------------------------------------------------
	// CONSTRUCTOR
	// ------------------------------------------------------------------------

	Result(Steps steps) {
		this.steps = steps;
	}

	// ------------------------------------------------------------------------
	// BUSINESS LOGIC
	// ------------------------------------------------------------------------

	public Steps getSteps() {
		return steps;
	}

	public boolean isVictory() {
		return false;
	}

	public boolean isDraw() {
		return false;
	}
}
