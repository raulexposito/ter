package com.raulexposito.model.game.game;

import com.raulexposito.model.board.Piece;
import com.raulexposito.model.movement.Movement;
import com.raulexposito.model.player.Player;

import static com.raulexposito.model.board.Placement.CENTER;

public class OnlyCenterPlayer extends Player {

    OnlyCenterPlayer(Piece piece) {
        super(piece, "OnlyCenterPlayer");
    }

    @Override
    public Movement move() {
        return add(CENTER);
    }
}