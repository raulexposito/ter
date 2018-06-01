package com.raulexposito.ter.renderer;

import com.raulexposito.ter.model.movement.Movement;

public class MovementRenderer {

	// ------------------------------------------------------------------------
	// ATTRIBUTES
	// ------------------------------------------------------------------------

	private final Movement movement;

	// ------------------------------------------------------------------------
	// CONSTRUCTOR
	// ------------------------------------------------------------------------

	public MovementRenderer(Movement movement) {
		this.movement = movement;
	}

	// ------------------------------------------------------------------------
	// BUSINESS LOGIC
	// ------------------------------------------------------------------------

	public String toJSON() {
		return "{" + addPiece() + addMovement() + addBoard() + "}";
	}

	// ------------------------------------------------------------------------
	// PRIVATE METHODS
	// ------------------------------------------------------------------------

	private String addPiece() {
		return "\"turn\":\"" + movement.getPiece().name() + "\",";
	}

	private String addMovement() {
		return "\"" + movement.getClass().getSimpleName().toLowerCase()
				+ "\": {" + movement.paramsAsJSON() + "},";
	}

	private String addBoard() {
		return "\"board\":" + movement.boardAsJSON();
	}
}
