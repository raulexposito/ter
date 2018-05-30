package com.raulexposito.ter.fixture.player.fake;

import com.raulexposito.ter.model.board.Piece;
import com.raulexposito.ter.model.board.Placement;
import com.raulexposito.ter.model.movement.Movement;
import com.raulexposito.ter.model.player.Player;

public class FakeAddPlayer extends Player {

    private final Placement placement;

    public FakeAddPlayer(Piece piece, Placement placement) {
        super(piece, "FakeAddPlayer");
        this.placement = placement;
    }

    @Override
    public Movement move() {
        return add(placement);
    }
}
