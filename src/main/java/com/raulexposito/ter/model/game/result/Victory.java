package com.raulexposito.ter.model.game.result;

import com.raulexposito.ter.model.board.Piece;
import com.raulexposito.ter.model.game.Step;
import com.raulexposito.ter.model.player.Player;

import java.util.Optional;

public class Victory extends Result {

    // ------------------------------------------------------------------------
    // ATTRIBUTES
    // ------------------------------------------------------------------------

    private final Piece winner;

    // ------------------------------------------------------------------------
    // CONSTRUCTOR
    // ------------------------------------------------------------------------

    public Victory(Step step, Piece winner, Player cross, Player circle) {
        super(step, cross, circle);
        this.winner = winner;
    }

    // ------------------------------------------------------------------------
    // BUSINESS LOGIC
    // ------------------------------------------------------------------------

    @Override
    public Optional<Piece> getWinner() {
        return Optional.of(winner);
    }

    @Override
    public boolean isVictory() {
        return true;
    }
}
