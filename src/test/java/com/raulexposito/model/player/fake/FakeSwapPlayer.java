package com.raulexposito.model.player.fake;

import com.raulexposito.model.board.Placement;
import com.raulexposito.model.board.Color;
import com.raulexposito.model.player.Player;
import com.raulexposito.model.movement.Movement;

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
