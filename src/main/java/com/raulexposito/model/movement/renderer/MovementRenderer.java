package com.raulexposito.model.movement.renderer;

import com.raulexposito.model.movement.Movement;

public class MovementRenderer {

	private final Movement movement;

	public MovementRenderer(Movement movement) {
		this.movement = movement;
	}

	public String toJSON() {
		return "{" + addPiece() + addMovement() + addBoard() + "}";
	}

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
