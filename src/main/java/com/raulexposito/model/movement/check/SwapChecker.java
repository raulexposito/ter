package com.raulexposito.model.movement.check;

import com.raulexposito.model.board.Board;
import com.raulexposito.model.board.Placement;
import com.raulexposito.model.board.Color;
import com.raulexposito.model.movement.execution.Failed;
import com.raulexposito.model.movement.execution.Execution;
import com.raulexposito.model.movement.execution.Valid;

public class SwapChecker {

	// ------------------------------------------------------------------------
	// CONSTANT VALUES
	// ------------------------------------------------------------------------

	private static final Integer SAME_COLOR_REQUIRED = 3;

	// ------------------------------------------------------------------------
	// BUSINESS LOGIC
	// ------------------------------------------------------------------------

	public Execution check(Board board, Color color, Placement current,
			Placement candidate) {
		if (notEnoughFilledSquares(board, color)
				|| notSwappingMyColor(board, color, current, candidate)
				|| bothSquaresAreFilled(board, current, candidate)) {
			return new Failed();
		}
		return new Valid();
	}

	// ------------------------------------------------------------------------
	// PRIVATE METHODS
	// ------------------------------------------------------------------------

	private boolean notEnoughFilledSquares(Board board, Color color) {
		return board.howMany(color) < SAME_COLOR_REQUIRED;
	}

	private boolean notSwappingMyColor(Board board, Color color,
			Placement current, Placement candidate) {
		return !board.hasColor(current, color)
				&& !board.hasColor(candidate, color);
	}

	private boolean bothSquaresAreFilled(Board board, Placement current,
			Placement candidate) {
		return board.isFilled(current) && board.isFilled(candidate);
	}
}
