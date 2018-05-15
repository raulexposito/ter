package com.raulexposito.model.player.fake;

import com.raulexposito.model.board.Placement;
import com.raulexposito.model.board.Color;
import com.raulexposito.model.player.Player;
import com.raulexposito.model.movement.Movement;

public class FakeAddPlayer extends Player {

    private final Placement placement;

    public FakeAddPlayer (Color color, Placement placement) {
        super(color);
        this.placement = placement;
    }

    @Override
    public Movement move() {
        return add(placement);
    }
}
