package com.raulexposito.ter.model.match.summary;

import com.raulexposito.ter.model.game.result.Result;
import com.raulexposito.ter.model.player.Player;

import java.util.ArrayList;
import java.util.List;

public class PieceSummary {

    // ------------------------------------------------------------------------
    // ATTRIBUTES
    // ------------------------------------------------------------------------

    private final List<Result> results;
    private final Player player;

    // ------------------------------------------------------------------------
    // CONSTRUCTOR
    // ------------------------------------------------------------------------

    public PieceSummary(List<Result> results, Player player) {
        this.results = new ArrayList<>(results);
        this.player = player;
    }

    // ------------------------------------------------------------------------
    // BUSINESS LOGIC
    // ------------------------------------------------------------------------

    public Long getVictories() {
        return results.parallelStream().filter(this::victories).count();
    }

    public Long getDraws() {
        return results.parallelStream().filter(this::draws).count();
    }

    public String getName() {
        return player.getName();
    }

    // ------------------------------------------------------------------------
    // PRIVATE METHODS
    // ------------------------------------------------------------------------

    private boolean victories(Result result) {
        return result.isVictory() && result.getWinner().map(player::isPiece).orElse(false);
    }

    private boolean draws(Result result) {
        return result.isDrawn();
    }
}
