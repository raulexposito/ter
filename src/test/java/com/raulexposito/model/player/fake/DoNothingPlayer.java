package com.raulexposito.model.player.fake;

import com.raulexposito.model.Color;
import com.raulexposito.model.player.Player;
import com.raulexposito.model.movement.Movement;

import static com.raulexposito.model.board.Placement.*;

public class DoNothingPlayer extends Player {

    public DoNothingPlayer (Color color) {
        super(color);
    }

    @Override
    public Movement move() {
        return add(CENTER);
    }
}