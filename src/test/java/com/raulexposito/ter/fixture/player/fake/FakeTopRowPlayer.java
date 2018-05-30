package com.raulexposito.ter.fixture.player.fake;

import com.raulexposito.ter.model.board.Piece;
import com.raulexposito.ter.model.board.Placement;
import com.raulexposito.ter.model.movement.Movement;
import com.raulexposito.ter.model.player.Player;

import static com.raulexposito.ter.model.board.Placement.*;

public class FakeTopRowPlayer extends Player {

    public FakeTopRowPlayer(Piece piece) {
        super(piece, "TopRowPlayer");
    }

    @Override
    public Movement move() {
        Placement placement;
        switch (this.mySquares().size()) {
            case 0:
                placement = TOP_LEFT;
                break;
            case 1:
                placement = TOP_CENTER;
                break;
            default:
                placement = TOP_RIGHT;
                break;
        }
        return add(placement);
    }
}