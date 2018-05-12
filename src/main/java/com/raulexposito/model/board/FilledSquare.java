package com.raulexposito.model.board;

import com.raulexposito.model.game.Color;

public class FilledSquare implements Square {

    // ------------------------------------------------------------------------
    // ATTRIBUTES
    // ------------------------------------------------------------------------

    private final Color color;

    // ------------------------------------------------------------------------
    // CONSTRUCTOR
    // ------------------------------------------------------------------------

    public FilledSquare(Color color) {
        this.color = color;
    }

    // ------------------------------------------------------------------------
    // BUSINESS LOGIC
    // ------------------------------------------------------------------------

    @Override
    public boolean isFilled() {
        return true;
    }

    @Override
    public boolean hasColor(Color color) {
        return this.color == color;
    }

    @Override
    public String toString() {
        return color.toString();
    }
}
