package com.raulexposito.model.square;

import com.raulexposito.model.Color;

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
}
