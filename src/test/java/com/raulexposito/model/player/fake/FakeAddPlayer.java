package com.raulexposito.model.player.fake;

import com.raulexposito.model.board.Piece;
import com.raulexposito.model.board.Placement;
import com.raulexposito.model.movement.Movement;
import com.raulexposito.model.player.Player;

public class FakeAddPlayer extends Player {

    private final Placement placement;

    public FakeAddPlayer (Piece piece, Placement placement) {
        super(piece);
        this.placement = placement;
    }

    @Override
    public Movement move() {
        return add(placement);
    }
}
