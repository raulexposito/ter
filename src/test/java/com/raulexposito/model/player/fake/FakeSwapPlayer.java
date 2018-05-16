package com.raulexposito.model.player.fake;

import com.raulexposito.model.board.Piece;
import com.raulexposito.model.board.Placement;
import com.raulexposito.model.movement.Movement;
import com.raulexposito.model.player.Player;

public class FakeSwapPlayer extends Player {

    private final Placement current;
    private final Placement candidate;

    public FakeSwapPlayer (Piece piece, Placement current, Placement candidate) {
        super(piece);
        this.current = current;
        this.candidate = candidate;
    }

    @Override
    public Movement move() {
        return swap(current, candidate);
    }
}
