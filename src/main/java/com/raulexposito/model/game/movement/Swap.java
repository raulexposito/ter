package com.raulexposito.model.game.movement;

import com.raulexposito.model.board.Board;
import com.raulexposito.model.Color;
import com.raulexposito.model.board.Placement;
import com.raulexposito.model.game.checker.SwapChecker;

public class Swap extends Movement {

	public Swap(Board board, Color color, Placement current, Placement candidate) {
		super(new SwapChecker().check(board, color, current, candidate), board
				.swap(current, candidate));
	}
}
