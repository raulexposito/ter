package com.raulexposito.model.cell;

import com.raulexposito.model.Color;

public class EmptyCell extends Cell {

    @Override
    public boolean isFilled() {
        return false;
    }

    @Override
    public boolean hasColor(Color color) {
        return false;
    }
}
