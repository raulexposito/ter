package com.raulexposito.model.board;

import com.raulexposito.model.game.Color;

public class NoContent implements Content {

    @Override
    public boolean isFilled() {
        return false;
    }

    @Override
    public boolean hasColor(Color color) {
        return false;
    }

    @Override
    public String toString() {
        return "· ";
    }
}
