package com.raulexposito.model.movement.check;

import com.raulexposito.model.board.Board;
import com.raulexposito.model.board.Placement;
import com.raulexposito.model.board.Color;
import com.raulexposito.model.movement.execution.Failed;
import com.raulexposito.model.movement.execution.Execution;
import com.raulexposito.model.movement.execution.Valid;

public class AddChecker {

	// ------------------------------------------------------------------------
	// CONSTANT VALUES
	// ------------------------------------------------------------------------

	private static final Long SAME_COLOR_MAXIMUM = 3L;

	// ------------------------------------------------------------------------
	// BUSINESS LOGIC
	// ------------------------------------------------------------------------

	public Execution check(Board board, Color color, Placement placement) {
		if (topColorIsReached(board, color)
				|| placementIsFilled(board, placement)) {
			return new Failed();
		}
		return new Valid();
	}

	// ------------------------------------------------------------------------
	// PRIVATE METHODS
	// ------------------------------------------------------------------------

	private boolean topColorIsReached(Board board, Color color) {
		return board.howMany(color).equals(SAME_COLOR_MAXIMUM);
	}

	private boolean placementIsFilled(Board board, Placement placement) {
		return board.isFilled(placement);
	}
}
