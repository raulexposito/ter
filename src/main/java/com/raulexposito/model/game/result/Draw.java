package com.raulexposito.model.game.result;

import com.raulexposito.model.game.Steps;

public class Draw extends Result {

    public Draw(Steps steps) {
        super(steps);
    }

    @Override
    public boolean isDraw() {
        return true;
    }
}
