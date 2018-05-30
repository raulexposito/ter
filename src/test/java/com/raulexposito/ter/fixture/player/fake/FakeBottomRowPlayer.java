package com.raulexposito.ter.fixture.player.fake;

import com.raulexposito.ter.model.board.Piece;
import com.raulexposito.ter.model.board.Placement;
import com.raulexposito.ter.model.movement.Movement;
import com.raulexposito.ter.model.player.Player;

import static com.raulexposito.ter.model.board.Placement.*;

public class FakeBottomRowPlayer extends Player {

    public FakeBottomRowPlayer(Piece piece) {
        super(piece, "BottomRowPlayer");
    }

    @Override
    public Movement move() {
        Placement placement;
        switch (this.mySquares().size()) {
            case 0:
                placement = BOTTOM_LEFT;
                break;
            case 1:
                placement = BOTTOM_CENTER;
                break;
            default:
                placement = BOTTOM_RIGHT;
                break;
        }
        return add(placement);
    }
}
