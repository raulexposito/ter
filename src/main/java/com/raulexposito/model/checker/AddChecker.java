package com.raulexposito.model.checker;

import com.raulexposito.model.Board;
import com.raulexposito.model.Result;
import com.raulexposito.model.Placement;
import com.raulexposito.model.Color;

public class AddChecker {

	// ------------------------------------------------------------------------
	// CONSTANT VALUES
	// ------------------------------------------------------------------------

	private static final Integer SAME_COLOR_TOP = 3;

	// ------------------------------------------------------------------------
	// BUSINESS LOGIC
	// ------------------------------------------------------------------------

	public Result check(Board board, Color color, Placement placement) {
		if (topColorIsReached(board, color)
				|| placementIsFilled(board, placement)) {
			return Result.FAILURE;
		}
		return Result.CONTINUE;
	}

	// ------------------------------------------------------------------------
	// PRIVATE METHODS
	// ------------------------------------------------------------------------

	private boolean topColorIsReached(Board board, Color color) {
		return board.count(color).equals(SAME_COLOR_TOP);
	}

	private boolean placementIsFilled(Board board, Placement placement) {
		return board.isPlacementFilled(placement);
	}
}
