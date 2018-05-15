package com.raulexposito.model.board;

public class Filled implements Content {

    // ------------------------------------------------------------------------
    // ATTRIBUTES
    // ------------------------------------------------------------------------

    private final Color color;

    // ------------------------------------------------------------------------
    // CONSTRUCTOR
    // ------------------------------------------------------------------------

    public Filled(Color color) {
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
