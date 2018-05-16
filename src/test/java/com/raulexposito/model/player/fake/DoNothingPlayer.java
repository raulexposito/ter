package com.raulexposito.model.player.fake;

import com.raulexposito.model.board.Piece;
import com.raulexposito.model.movement.Movement;
import com.raulexposito.model.player.Player;

import static com.raulexposito.model.board.Placement.CENTER;

public class DoNothingPlayer extends Player {

    public DoNothingPlayer (Piece piece) {
        super(piece);
    }

    @Override
    public Movement move() {
        return add(CENTER);
    }
}