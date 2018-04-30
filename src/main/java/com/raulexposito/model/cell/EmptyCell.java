package com.raulexposito.model.cell;

import java.util.Optional;

public class EmptyCell extends Cell {

    @Override
    public boolean isFilled() {
        return false;
    }

    @Override
    public Optional<FilledCell> fill(Chip chip) {
        return Optional.of(new FilledCell(chip));
    }

    @Override
    public Optional<EmptyCell> empty() {
        return Optional.empty();
    }

    @Override
    public boolean isChip(Chip chip) {
        return false;
    }
}
