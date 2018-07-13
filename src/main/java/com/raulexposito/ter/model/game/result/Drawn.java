package com.raulexposito.ter.model.game.result;

import com.raulexposito.ter.model.board.Piece;
import com.raulexposito.ter.model.game.Step;
import com.raulexposito.ter.model.player.Player;

import java.util.Optional;

public class Drawn extends Result {

    // ------------------------------------------------------------------------
    // CONSTRUCTOR
    // ------------------------------------------------------------------------

    public Drawn(Step step, Player cross, Player circle) {
        super(step, cross, circle);
    }

    // ------------------------------------------------------------------------
    // BUSINESS LOGIC
    // ------------------------------------------------------------------------

    @Override
    public boolean isDrawn() {
        return true;
    }

    @Override
    public Optional<Piece> getWinner() {
        return Optional.empty();
    }
}
