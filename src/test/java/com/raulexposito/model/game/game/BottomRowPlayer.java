package com.raulexposito.model.game.game;

import com.raulexposito.model.board.Piece;
import com.raulexposito.model.board.Placement;
import com.raulexposito.model.movement.Movement;
import com.raulexposito.model.player.Player;

import static com.raulexposito.model.board.Placement.*;

public class BottomRowPlayer extends Player {

    public BottomRowPlayer(Piece piece) {
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
