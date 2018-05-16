package com.raulexposito.model.movement.check;

import com.raulexposito.model.board.Board;
import com.raulexposito.model.board.Piece;
import com.raulexposito.model.board.Placement;
import com.raulexposito.model.movement.execution.Execution;
import com.raulexposito.model.movement.execution.Failed;
import com.raulexposito.model.movement.execution.Valid;

public class SwapChecker {

	// ------------------------------------------------------------------------
	// CONSTANT VALUES
	// ------------------------------------------------------------------------

	private static final Integer SAME_PIECES_AMOUNT_REQUIRED = 3;

	// ------------------------------------------------------------------------
	// BUSINESS LOGIC
	// ------------------------------------------------------------------------

	public Execution check(Board board, Piece piece, Placement current,
			Placement candidate) {
		if (notEnoughFilledSquares(board, piece)
				|| notSwappingMyPiece(board, piece, current, candidate)
				|| bothSquaresAreFilled(board, current, candidate)) {
			return new Failed();
		}
		return new Valid();
	}

	// ------------------------------------------------------------------------
	// PRIVATE METHODS
	// ------------------------------------------------------------------------

	private boolean notEnoughFilledSquares(Board board, Piece piece) {
		return board.howMany(piece) < SAME_PIECES_AMOUNT_REQUIRED;
	}

	private boolean notSwappingMyPiece(Board board, Piece piece,
			Placement current, Placement candidate) {
		return !board.hasPiece(current, piece)
				&& !board.hasPiece(candidate, piece);
	}

	private boolean bothSquaresAreFilled(Board board, Placement current,
			Placement candidate) {
		return board.isFilled(current) && board.isFilled(candidate);
	}
}
