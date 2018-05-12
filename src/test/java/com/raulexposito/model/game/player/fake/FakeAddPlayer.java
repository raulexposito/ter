package com.raulexposito.model.game.player.fake;

import com.raulexposito.model.board.Placement;
import com.raulexposito.model.game.Color;
import com.raulexposito.model.game.Player;
import com.raulexposito.model.game.movement.Movement;

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
