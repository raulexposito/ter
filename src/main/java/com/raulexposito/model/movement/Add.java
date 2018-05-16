package com.raulexposito.model.movement;

import com.raulexposito.model.board.Board;
import com.raulexposito.model.board.Piece;
import com.raulexposito.model.board.Placement;
import com.raulexposito.model.movement.check.AddChecker;

public class Add extends Movement {

	private static final AddChecker CHECKER = new AddChecker();

	public Add(Board board, Piece piece, Placement placement) {
		super(CHECKER.check(board, piece, placement), board.add(piece,
				placement));
	}
}
