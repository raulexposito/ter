package com.raulexposito.model.game.player.fake;

import com.raulexposito.model.board.Placement;
import com.raulexposito.model.game.Color;
import com.raulexposito.model.game.Player;
import com.raulexposito.model.game.movement.Movement;

public class FakeSwapPlayer extends Player {

    private final Placement current;
    private final Placement candidate;

    public FakeSwapPlayer (Color color, Placement current, Placement candidate) {
        super(color);
        this.current = current;
        this.candidate = candidate;
    }

    @Override
    public Movement move() {
        return swap(current, candidate);
    }
}
