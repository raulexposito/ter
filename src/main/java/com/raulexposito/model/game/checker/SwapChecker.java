package com.raulexposito.model.game.checker;

import com.raulexposito.model.board.Board;
import com.raulexposito.model.Result;
import com.raulexposito.model.board.Placement;
import com.raulexposito.model.Color;

public class SwapChecker {

	// ------------------------------------------------------------------------
	// CONSTANT VALUES
	// ------------------------------------------------------------------------

	private static final Integer SAME_COLOR_REQUIRED = 3;

	// ------------------------------------------------------------------------
	// BUSINESS LOGIC
	// ------------------------------------------------------------------------

	public Result check(Board board, Color color, Placement current,
			Placement candidate) {
		if (notEnoughFilledSquares(board, color)
				|| notSwappingMyColor(board, color, current, candidate)
				|| bothSquaresAreFilled(board, current, candidate)) {
			return Result.FAILURE;
		}
		return Result.VALID;
	}

	// ------------------------------------------------------------------------
	// PRIVATE METHODS
	// ------------------------------------------------------------------------

	private boolean notEnoughFilledSquares(Board board, Color color) {
		return board.howMany(color) < SAME_COLOR_REQUIRED;
	}

	private boolean notSwappingMyColor(Board board, Color color,
			Placement current, Placement candidate) {
		return !board.squareHasColor(current, color)
				&& !board.squareHasColor(candidate, color);
	}

	private boolean bothSquaresAreFilled(Board board, Placement current,
			Placement candidate) {
		return board.isPlacementFilled(current)
				&& board.isPlacementFilled(candidate);
	}
}
