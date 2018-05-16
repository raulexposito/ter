package com.raulexposito.model.game.result;

import com.raulexposito.model.board.Piece;
import com.raulexposito.model.game.Movements;

import java.util.Optional;

public abstract class Result {

	// ------------------------------------------------------------------------
	// ATTRIBUTES
	// ------------------------------------------------------------------------

	private final Movements movements;

	// ------------------------------------------------------------------------
	// CONSTRUCTOR
	// ------------------------------------------------------------------------

	Result(Movements movements) {
		this.movements = movements;
	}

	// ------------------------------------------------------------------------
	// BUSINESS LOGIC
	// ------------------------------------------------------------------------

	public abstract Optional<Piece> getWinner();

	public boolean isVictory() {
		return false;
	}

	public boolean isDrawn() {
		return false;
	}

	public String movementsAsJSON() {
		return movements.toString();
	}
}
