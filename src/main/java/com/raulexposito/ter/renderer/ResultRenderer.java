package com.raulexposito.ter.renderer;

import com.raulexposito.ter.model.game.result.Result;

public class ResultRenderer {

	// ------------------------------------------------------------------------
	// ATTRIBUTES
	// ------------------------------------------------------------------------

	private final Result result;

	// ------------------------------------------------------------------------
	// CONSTRUCTOR
	// ------------------------------------------------------------------------

	public ResultRenderer(Result result) {
		this.result = result;
	}

	// ------------------------------------------------------------------------
	// BUSINESS LOGIC
	// ------------------------------------------------------------------------

	public String toJSON() {
		return "{" + addResult() + addWinner() + addCrossPlayer()
				+ addCirclePlayer() + addLength() + addMovements() + "}";
	}

	// ------------------------------------------------------------------------
	// PRIVATE METHODS
	// ------------------------------------------------------------------------

	private String addResult() {
		return "\"result\":\""
				+ result.getClass().getSimpleName().toUpperCase() + "\",";
	}

	private String addWinner() {
        return result.getWinner().map(it -> fillName(it.name())).orElse("");
    }

	private String fillName(String name) {
		return "\"winner\":\"" + name + "\",";
	}

	private String addLength() {
		return "\"length\":" + result.getMovementsLength() + ",";
	}

	private String addMovements() {
		return "\"movements\":" + result.getMovementsAsJSON();
	}

	private String addCrossPlayer() {
		return "\"cross\":\"" + result.getCrossPlayerName() + "\",";
	}

	private String addCirclePlayer() {
		return "\"circle\":\"" + result.getCirclePlayerName() + "\",";
	}
}
