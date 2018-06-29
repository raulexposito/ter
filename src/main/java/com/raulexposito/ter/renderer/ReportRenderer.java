package com.raulexposito.ter.renderer;

import com.raulexposito.ter.model.game.result.Result;
import com.raulexposito.ter.model.match.summary.Overall;
import com.raulexposito.ter.model.match.summary.PieceSummary;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReportRenderer {

	// ------------------------------------------------------------------------
	// ATTRIBUTES
	// ------------------------------------------------------------------------

	private final Overall overall;
	private final PieceSummary cross;
	private final PieceSummary circle;
	private final Stream<Result> results;

	// ------------------------------------------------------------------------
	// CONSTRUCTOR
	// ------------------------------------------------------------------------

	public ReportRenderer(List<Result> results, Overall overall, PieceSummary cross, PieceSummary circle) {
		this.overall = overall;
		this.results = results.stream();
		this.cross = cross;
		this.circle = circle;
	}

	// ------------------------------------------------------------------------
	// BUSINESS LOGIC
	// ------------------------------------------------------------------------

	public String toJSON() {
		return "{" + addId() + addStarts() + addEnds() + addDuration() + addAmount() + addVictories() + addDraws() + addCross() + addCircle() + addResults() + "}";
	}

	// ------------------------------------------------------------------------
	// PRIVATE METHODS
	// ------------------------------------------------------------------------

	private String addId() {
		return "\"id\":\"" + overall.getId() + "\",";
	}

	private String addStarts() {
		return "\"started\":\"" + overall.getStarts() + "\",";
	}

	private String addEnds() {
		return "\"ended\":\"" + overall.getEnds() + "\",";
	}

	private String addDuration() {
		return "\"duration\":\"" + overall.getDuration() + "\",";
	}

	private String addAmount() {
		return "\"amount\":\"" + overall.getLength() + "\",";
	}

	private String addVictories() {
		return "\"victories\":\"" + overall.getVictories() + "\",";
	}

	private String addDraws() {
		return "\"draws\":\"" + overall.getDraws() + "\",";
	}

	private String addCross() {
		return addPiece("cross", cross);
	}

	private String addCircle() {
		return addPiece("circle", circle);
	}

	private String addPiece (String piece, PieceSummary summary) {
		return "\"" + piece + "\": {\"name\":\"" + summary.getName() + "\"," +
			"\"victories\": " + summary.getVictories() + "," +
			"\"draws\": " + summary.getDraws() + "},";
	}

	private String addResults() {
		return "\"results\":"
				+ "[" + String.join(",", results.map(
				Result::toJSON).collect(Collectors.toList())) + "]";
	}
}
