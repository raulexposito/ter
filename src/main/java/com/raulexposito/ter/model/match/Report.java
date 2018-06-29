package com.raulexposito.ter.model.match;

import com.raulexposito.ter.model.game.result.Result;
import com.raulexposito.ter.model.match.summary.Overall;
import com.raulexposito.ter.model.match.summary.PieceSummary;
import com.raulexposito.ter.model.player.Player;
import com.raulexposito.ter.renderer.ReportRenderer;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Report {

    // ------------------------------------------------------------------------
    // ATTRIBUTES
    // ------------------------------------------------------------------------

    private final List<Result> results;
    private final UUID uuid;
    private final Long starts;
    private final Long ends;
    private final Player cross;
    private final Player circle;

    // ------------------------------------------------------------------------
    // CONSTRUCTOR
    // ------------------------------------------------------------------------

    static Report withCapacity(Integer capacity, Player cross, Player circle) {
        return new Report(
                UUID.randomUUID(),
                new ArrayList<>(capacity),
                System.currentTimeMillis(),
                cross, circle);
    }

    private Report(UUID uuid, List<Result> results, Long starts, Player cross, Player circle) {
        this.uuid = uuid;
        this.results = new ArrayList<>(results);
        this.starts = starts;
        this.ends = System.currentTimeMillis();
        this.cross = cross;
        this.circle = circle;
    }

    // ------------------------------------------------------------------------
    // BUSINESS LOGIC
    // ------------------------------------------------------------------------

    Report add(Result result) {
        this.results.add(result);
        return new Report(uuid, results, starts, cross, circle);
    }

    // ------------------------------------------------------------------------
    // GETTERS
    // ------------------------------------------------------------------------

    public String toJSON() {
        return new ReportRenderer(results, new Overall(results, uuid, starts, ends), new PieceSummary(results, cross), new PieceSummary(results, circle)).toJSON();
    }
}
