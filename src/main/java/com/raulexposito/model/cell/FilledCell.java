package com.raulexposito.model.cell;

public class FilledCell extends Cell {

    // ------------------------------------------------------------------------
    // ATTRIBUTES
    // ------------------------------------------------------------------------

    private final Chip chip;

    // ------------------------------------------------------------------------
    // CONSTRUCTOR
    // ------------------------------------------------------------------------

    public FilledCell(Chip chip) {
        this.chip = chip;
    }

    // ------------------------------------------------------------------------
    // BUSINESS LOGIC
    // ------------------------------------------------------------------------

    @Override
    public boolean isFilled() {
        return true;
    }

    @Override
    public boolean isChip(Chip chip) {
        return this.chip == chip;
    }
}
