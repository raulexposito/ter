package com.raulexposito.model.game.result;

import com.raulexposito.model.Color;
import com.raulexposito.model.game.Steps;

public class Victory extends Result {

    // ------------------------------------------------------------------------
    // ATTRIBUTES
    // ------------------------------------------------------------------------

    private Color winner;

    // ------------------------------------------------------------------------
    // CONSTRUCTOR
    // ------------------------------------------------------------------------

    public Victory(Steps steps, Color winner) {
        super(steps);
        this.winner = winner;
    }

    // ------------------------------------------------------------------------
    // BUSINESS LOGIC
    // ------------------------------------------------------------------------

    public Color getWinner() {
        return winner;
    }

    @Override
    public boolean isVictory() {
        return true;
    }
}
