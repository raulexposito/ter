package com.raulexposito.model.player;

import com.raulexposito.model.board.Placement;
import com.raulexposito.model.Color;
import com.raulexposito.model.movement.Add;
import com.raulexposito.model.movement.Movement;
import com.raulexposito.model.board.Board;
import com.raulexposito.model.movement.Swap;

import java.util.List;

public abstract class Player {

	// ------------------------------------------------------------------------
	// ATTRIBUTES
	// ------------------------------------------------------------------------

	private final Color color;
	private Board board;
	private Knowledge knowledge;

	// ------------------------------------------------------------------------
	// CONSTRUCTOR
	// ------------------------------------------------------------------------

	public Player(Color color) {
		this.color = color;
	}

	// ------------------------------------------------------------------------
	// BUSINESS LOGIC
	// ------------------------------------------------------------------------

	public Movement move(Board board) {
		this.board = board;
		this.knowledge = new Knowledge(board, color);
		return move();
	}

	public abstract Movement move();

	// ------------------------------------------------------------------------
	// PROTECTED METHODS
	// ------------------------------------------------------------------------

	protected Movement add(Placement placement) {
		return new Add(board, color, placement);
	}

	protected Movement swap(Placement current, Placement candidate) {
		return new Swap(board, color, current, candidate);
	}

	boolean canAdd () {
		return knowledge.canAdd();
	}

	List<Placement> mySquares() {
		return knowledge.mySquares();
	}

	List<Placement> rivalSquares() {
		return knowledge.rivalSquares();
	}

	List<Placement> emptySquares() {
		return knowledge.emptySquares();
	}
}
