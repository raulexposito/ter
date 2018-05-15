package com.raulexposito.model.game.result;

import com.raulexposito.model.board.Color;
import com.raulexposito.model.game.Steps;

import java.util.Optional;

public class Draw extends Result {

    public Draw(Steps steps) {
        super(steps);
    }

    @Override
    public boolean isDraw() {
        return true;
    }

    @Override
    public Optional<Color> getWinner() {
        return Optional.empty();
    }
}
