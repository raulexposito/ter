package com.raulexposito.model.movement;

import com.raulexposito.model.board.Board;
import com.raulexposito.model.board.Color;
import com.raulexposito.model.board.Placement;
import com.raulexposito.model.movement.check.AddChecker;

public class Add extends Movement {

	private static final AddChecker CHECKER = new AddChecker();

	public Add(Board board, Color color, Placement placement) {
		super(CHECKER.check(board, color, placement), board.add(color,
				placement));
	}
}
