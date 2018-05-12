package com.raulexposito.model.player;

import com.raulexposito.model.board.Placement;
import com.raulexposito.model.Color;
import com.raulexposito.model.movement.Add;
import com.raulexposito.model.movement.Movement;
import com.raulexposito.model.board.Board;
import com.raulexposito.model.movement.Swap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Player {

	// ------------------------------------------------------------------------
	// CONSTANTS
	// ------------------------------------------------------------------------

	private static final Integer MAX_SAME_COLOR_PIECES = 3;
	private static final Integer BOARD_SIZE = 9;

	// ------------------------------------------------------------------------
	// ATTRIBUTES
	// ------------------------------------------------------------------------

	private Color color;
	private Board board;
	private List<Placement> mine = new ArrayList<>(MAX_SAME_COLOR_PIECES);
	private List<Placement> rival = new ArrayList<>(MAX_SAME_COLOR_PIECES);
	private List<Placement> empty = new ArrayList<>(BOARD_SIZE);

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

	boolean canAdd () {
		return mine.size() < MAX_SAME_COLOR_PIECES;
	}

	List<Placement> mySquares() {
		return new ArrayList<>(mine);
	}

	List<Placement> rivalSquares() {
		return new ArrayList<>(rival);
	}

	List<Placement> emptySquares() {
		return new ArrayList<>(empty);
	}

	// ------------------------------------------------------------------------
	// PRIVATE METHODS
	// ------------------------------------------------------------------------

	// TODO: tal vez el jugador deberia mantener una estructura inmutable con esta informacion
	private void fillLists(Board board) {
		resetLists();
		Arrays.stream(Placement.values()).forEach(placement -> {
			if (board.isEmpty(placement)) {
				empty.add(placement);
			} else if (board.hasColor(placement, color)) {
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
