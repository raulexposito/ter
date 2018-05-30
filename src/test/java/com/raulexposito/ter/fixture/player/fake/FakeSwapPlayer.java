package com.raulexposito.ter.fixture.player.fake;

import com.raulexposito.ter.model.board.Piece;
import com.raulexposito.ter.model.board.Placement;
import com.raulexposito.ter.model.movement.Movement;
import com.raulexposito.ter.model.player.Player;

public class FakeSwapPlayer extends Player {

    private final Placement current;
    private final Placement candidate;

    public FakeSwapPlayer(Piece piece, Placement current, Placement candidate) {
        super(piece, "FakeSwapPlayer");
        this.current = current;
        this.candidate = candidate;
    }

    @Override
    public Movement move() {
        return swap(current, candidate);
    }
}
