package com.raulexposito.model.game.result;

import com.raulexposito.model.board.Piece;
import com.raulexposito.model.game.Movements;

import java.util.Optional;

public class Victory extends Result {

    // ------------------------------------------------------------------------
    // ATTRIBUTES
    // ------------------------------------------------------------------------

    private final Piece winner;

    // ------------------------------------------------------------------------
    // CONSTRUCTOR
    // ------------------------------------------------------------------------

    public Victory(Movements movements, Piece winner) {
        super(movements);
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
