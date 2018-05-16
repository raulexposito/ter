package com.raulexposito.model.movement;

import com.raulexposito.model.board.Board;
import com.raulexposito.model.board.Piece;
import com.raulexposito.model.board.Placement;
import com.raulexposito.model.movement.check.SwapChecker;

public class Swap extends Movement {

	private static final SwapChecker CHECKER = new SwapChecker();

	public Swap(Board board, Piece piece, Placement current, Placement candidate) {
		super(CHECKER.check(board, piece, current, candidate), board.swap(
				current, candidate));
	}
}
