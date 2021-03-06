package com.raulexposito.ter.model.movement.check;

import com.raulexposito.ter.model.board.Board;
import com.raulexposito.ter.model.board.Piece;
import com.raulexposito.ter.model.board.Placement;
import com.raulexposito.ter.model.movement.execution.Execution;
import com.raulexposito.ter.model.movement.execution.Failed;
import com.raulexposito.ter.model.movement.execution.Valid;

public class AddChecker {

	// ------------------------------------------------------------------------
	// CONSTANT VALUES
	// ------------------------------------------------------------------------

	private static final Long SAME_PIECES_MAXIMUM = 3L;

	// ------------------------------------------------------------------------
	// BUSINESS LOGIC
	// ------------------------------------------------------------------------

	public Execution check(Board board, Piece piece, Placement placement) {
		if (topPiecesIsReached(board, piece)
				|| placementIsFilled(board, placement)) {
			return new Failed();
		}
		return new Valid();
	}

	// ------------------------------------------------------------------------
	// PRIVATE METHODS
	// ------------------------------------------------------------------------

	private boolean topPiecesIsReached(Board board, Piece piece) {
		return board.howMany(piece).equals(SAME_PIECES_MAXIMUM);
	}

	private boolean placementIsFilled(Board board, Placement placement) {
		return board.isFilled(placement);
	}
}
