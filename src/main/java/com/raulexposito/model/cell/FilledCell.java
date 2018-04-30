package com.raulexposito.model.cell;

import java.util.Optional;

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
    public Optional<FilledCell> fill(Chip chip) {
        return Optional.empty();
    }

    @Override
    public Optional<EmptyCell> empty() {
        return Optional.of(new EmptyCell());
    }

    @Override
    public boolean isChip(Chip chip) {
        return this.chip == chip;
    }
}
