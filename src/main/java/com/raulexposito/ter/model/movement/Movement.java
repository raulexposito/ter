package com.raulexposito.ter.model.movement;

import com.raulexposito.ter.model.board.Board;
import com.raulexposito.ter.model.board.Piece;
import com.raulexposito.ter.model.game.checker.VictoryChecker;
import com.raulexposito.ter.model.movement.execution.Execution;
import com.raulexposito.ter.renderer.MovementRenderer;

public abstract class Movement {

	// ------------------------------------------------------------------------
	// ATTRIBUTES
	// ------------------------------------------------------------------------

	private final Board board;

	private final Execution execution;

	private final Piece piece;

	// ------------------------------------------------------------------------
	// CONSTRUCTOR
	// ------------------------------------------------------------------------

	Movement(Execution execution, Piece piece, Board board) {
		this.execution = execution;
		this.board = board;
		this.piece = piece;
	}

	// ------------------------------------------------------------------------
	// ABSTRACT METHODS
	// ------------------------------------------------------------------------

	public abstract String paramsAsJSON();

	// ------------------------------------------------------------------------
	// GETTERS
	// ------------------------------------------------------------------------

	public boolean isFailed() {
		return execution.isFailed();
	}

	public boolean isVictory() {
		return execution.isValid() && new VictoryChecker(board).isVictory();
	}

	public Board getBoard() {
		return board;
	}

	public Piece getPiece() {
		return piece;
	}

	public String boardAsJSON() {
		return board.toJSON();
	}

	public String toJSON() {
		return new MovementRenderer(this).toJSON();
	}
}
