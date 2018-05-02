package com.raulexposito.model.cell;

public class EmptyCell extends Cell {

    @Override
    public boolean isFilled() {
        return false;
    }

    @Override
    public boolean isChip(Chip chip) {
        return false;
    }
}
