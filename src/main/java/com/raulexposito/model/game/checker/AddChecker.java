package com.raulexposito.model.game.checker;

import com.raulexposito.model.board.Board;
import com.raulexposito.model.Result;
import com.raulexposito.model.board.Placement;
import com.raulexposito.model.Color;

public class AddChecker {

	// ------------------------------------------------------------------------
	// CONSTANT VALUES
	// ------------------------------------------------------------------------

	private static final Integer SAME_COLOR_MAXIMUM = 3;

	// ------------------------------------------------------------------------
	// BUSINESS LOGIC
	// ------------------------------------------------------------------------

	public Result check(Board board, Color color, Placement placement) {
		if (topColorIsReached(board, color)
				|| placementIsFilled(board, placement)) {
			return Result.FAILURE;
		}
		return Result.VALID;
	}

	// ------------------------------------------------------------------------
	// PRIVATE METHODS
	// ------------------------------------------------------------------------

	private boolean topColorIsReached(Board board, Color color) {
		return board.howMany(color).equals(SAME_COLOR_MAXIMUM);
	}

	private boolean placementIsFilled(Board board, Placement placement) {
		return board.isPlacementFilled(placement);
	}
}
