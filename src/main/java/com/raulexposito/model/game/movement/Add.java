package com.raulexposito.model.game.movement;

import com.raulexposito.model.board.Board;
import com.raulexposito.model.Color;
import com.raulexposito.model.board.Placement;
import com.raulexposito.model.game.checker.AddChecker;

public class Add extends Movement {

	private static final AddChecker CHECKER = new AddChecker();

	public Add(Board board, Color color, Placement placement) {
		super(CHECKER.check(board, color, placement), board.add(color,
				placement));
	}
}
