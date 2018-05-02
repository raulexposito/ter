package com.raulexposito.model.checker;

import com.raulexposito.model.Board;
import com.raulexposito.model.Result;
import com.raulexposito.model.Placement;
import com.raulexposito.model.Color;

public class SwapChecker {

	// ------------------------------------------------------------------------
	// CONSTANT VALUES
	// ------------------------------------------------------------------------

	private static final Integer SAME_COLOR_TOP = 3;

	// ------------------------------------------------------------------------
	// BUSINESS LOGIC
	// ------------------------------------------------------------------------

	public Result check(Board board, Color color, Placement current,
			Placement candidate) {
		if (swapIsInvalid(board, color, current, candidate)) {
			return Result.FAILURE;
		}
		return Result.CONTINUE;
	}

	// ------------------------------------------------------------------------
	// PRIVATE METHODS
	// ------------------------------------------------------------------------

	private boolean swapIsInvalid(Board board, Color color, Placement current,
			Placement candidate) {
		return board.count(color) < SAME_COLOR_TOP
				|| !board.placementHasColor(current, color)
				|| board.isPlacementEmpty(current)
				|| board.isPlacementFilled(candidate);
	}
}
