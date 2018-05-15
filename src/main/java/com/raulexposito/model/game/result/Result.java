package com.raulexposito.model.game.result;

import com.raulexposito.model.board.Color;
import com.raulexposito.model.game.Steps;

import java.util.Optional;

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

	public abstract Optional<Color> getWinner();

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
