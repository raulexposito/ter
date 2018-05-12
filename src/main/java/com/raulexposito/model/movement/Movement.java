package com.raulexposito.model.movement;

import com.raulexposito.model.board.Board;
import com.raulexposito.model.game.checker.VictoryChecker;
import com.raulexposito.model.movement.execution.Execution;

public abstract class Movement {

	// ------------------------------------------------------------------------
	// ATTRIBUTES
	// ------------------------------------------------------------------------

	private final Board board;

	private final Execution execution;

	private boolean victory;

	// ------------------------------------------------------------------------
	// CONSTRUCTOR
	// ------------------------------------------------------------------------

	Movement(Execution execution, Board board) {
		this.execution = execution;
		this.board = board;
		if (execution.isValid()) {
			this.victory = new VictoryChecker().isVictory(board);
		}
	}

	// ------------------------------------------------------------------------
	// GETTERS
	// ------------------------------------------------------------------------

	public boolean isFailed() {
		return execution.isFailed();
	}

	public boolean isVictory() {
		return victory;
	}

	public Board getBoard() {
		return board;
	}
}
