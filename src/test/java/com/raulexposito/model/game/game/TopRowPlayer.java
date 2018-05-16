package com.raulexposito.model.game.game;

import com.raulexposito.model.board.Piece;
import com.raulexposito.model.board.Placement;
import com.raulexposito.model.movement.Movement;
import com.raulexposito.model.player.Player;

import static com.raulexposito.model.board.Placement.*;

public class TopRowPlayer extends Player {

    TopRowPlayer(Piece piece) {
        super(piece);
    }

    @Override
    public Movement move() {
        Placement placement;
        switch (this.mySquares().size()) {
            case 0: placement = TOP_LEFT; break;
            case 1: placement = TOP_CENTER; break;
            default: placement = TOP_RIGHT; break;
        }
        return add(placement);
    }
}