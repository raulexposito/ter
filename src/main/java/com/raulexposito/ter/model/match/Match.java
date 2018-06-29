package com.raulexposito.ter.model.match;

import com.raulexposito.ter.model.game.Counter;
import com.raulexposito.ter.model.game.Game;
import com.raulexposito.ter.model.player.Player;

public class Match {

	// ------------------------------------------------------------------------
	// ATTRIBUTES
	// ------------------------------------------------------------------------

	private final Report report;

	// ------------------------------------------------------------------------
	// CONSTRUCTOR
	// ------------------------------------------------------------------------

	public Match(Player cross, Player circle, Integer amount) {
		this.report = generateReport(new Flow(cross, circle, amount));
	}

	private Report generateReport(Flow flow) {
		if (flow.isLimitReached()) {
			return flow.report;
		}
		return generateReport(flow.next());
	}

	// ------------------------------------------------------------------------
	// GETTERS
	// ------------------------------------------------------------------------

	public Report getReport() {
		return report;
	}

	// ------------------------------------------------------------------------
	// INNER CLASSES
	// ------------------------------------------------------------------------

	private class Flow {

		// --------------------------------------------------------------------
		// ATTRIBUTES
		// --------------------------------------------------------------------

		private final Player cross;
		private final Player circle;
		private final Counter counter;
		private final Report report;

		// --------------------------------------------------------------------
		// CONSTRUCTORS
		// --------------------------------------------------------------------

		Flow(Player cross, Player circle, Integer amount) {
			this(cross, circle, Counter.upTo(amount), Report.withCapacity(
					amount, cross, circle));
		}

		private Flow(Player cross, Player circle, Counter counter, Report report) {
			this.cross = cross;
			this.circle = circle;
			this.counter = counter;
			this.report = report;
		}

		// --------------------------------------------------------------------
		// BUSINESS LOGIC
		// --------------------------------------------------------------------

		Flow next() {
			return new Flow(cross, circle, counter.increase(),
					report.add(new Game(cross, circle).play()));
		}

		boolean isLimitReached() {
			return counter.limitReached();
		}
	}
}
