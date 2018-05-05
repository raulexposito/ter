package com.raulexposito.model.game;

import com.raulexposito.model.*;
import com.raulexposito.model.game.movement.Movement;
import com.raulexposito.model.game.movement.Swap;
import com.raulexposito.model.board.Board;

import static com.raulexposito.model.board.Placement.*;

public class Player {

	private Color color;

	public Player(Color color) {
		this.color = color;
	}

	public Movement move(Board board) {
		return new Swap(board, color, TOP_LEFT, CENTER);
//		return new AddCommand(board, color, Placement.TOP_LEFT);
	}
}
