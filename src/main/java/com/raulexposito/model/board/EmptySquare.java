package com.raulexposito.model.board;

import com.raulexposito.model.Color;

public class EmptySquare implements Square {

    @Override
    public boolean isFilled() {
        return false;
    }

    @Override
    public boolean hasColor(Color color) {
        return false;
    }
}
