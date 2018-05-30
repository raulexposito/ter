package com.raulexposito.ter.fixture.player.fake;

import com.raulexposito.ter.model.board.Piece;
import com.raulexposito.ter.model.movement.Movement;
import com.raulexposito.ter.model.player.Player;

import static com.raulexposito.ter.model.board.Placement.CENTER;

public class FakeOnlyCenterPlayer extends Player {

    public FakeOnlyCenterPlayer(Piece piece) {
        super(piece, "OnlyCenterPlayer");
    }

    @Override
    public Movement move() {
        return add(CENTER);
    }
}