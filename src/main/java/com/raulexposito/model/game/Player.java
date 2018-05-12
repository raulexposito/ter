package com.raulexposito.model.game;

import com.raulexposito.model.board.Placement;
import com.raulexposito.model.game.movement.Add;
import com.raulexposito.model.game.movement.Movement;
import com.raulexposito.model.board.Board;
import com.raulexposito.model.game.movement.Swap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Player {

	// ------------------------------------------------------------------------
	// ATTRIBUTES
	// ------------------------------------------------------------------------

	private Color color;
	private Board board;
	private List<Placement> mine = new ArrayList<>(3);
	private List<Placement> rival = new ArrayList<>(3);
	private List<Placement> empty = new ArrayList<>(9);

	// ------------------------------------------------------------------------
	// CONSTRUCTOR
	// ------------------------------------------------------------------------

	public Player(Color color) {
		this.color = color;
	}

	// ------------------------------------------------------------------------
	// BUSINESS LOGIC
	// ------------------------------------------------------------------------

	Movement move(Board board) {
		this.board = board;
		this.fillLists(board);
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

	protected boolean canAdd () {
		return mine.size() < 3;
	}

	protected List<Placement> mySquares() {
		return new ArrayList<>(mine);
	}

	protected List<Placement> rivalSquares() {
		return new ArrayList<>(rival);
	}

	protected List<Placement> emptySquares() {
		return new ArrayList<>(empty);
	}

	// ------------------------------------------------------------------------
	// PRIVATE METHODS
	// ------------------------------------------------------------------------

	private void fillLists(Board board) {
		resetLists();
		Arrays.stream(Placement.values()).forEach(placement -> {
			if (board.isSquareEmpty(placement)) {
				empty.add(placement);
			} else if (board.squareHasColor(placement, color)) {
				mine.add(placement);
			} else {
				rival.add(placement);
			}
		});
	}

	private void resetLists() {
		mine.clear();
		rival.clear();
		empty.clear();
	}
}
