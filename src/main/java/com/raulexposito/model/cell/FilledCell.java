package com.raulexposito.model.cell;

import com.raulexposito.model.Color;

public class FilledCell extends Cell {

    // ------------------------------------------------------------------------
    // ATTRIBUTES
    // ------------------------------------------------------------------------

    private final Color color;

    // ------------------------------------------------------------------------
    // CONSTRUCTOR
    // ------------------------------------------------------------------------

    public FilledCell(Color color) {
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
