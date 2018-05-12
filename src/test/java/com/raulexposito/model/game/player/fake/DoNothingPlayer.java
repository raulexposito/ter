package com.raulexposito.model.game.player.fake;

import com.raulexposito.model.game.Color;
import com.raulexposito.model.game.Player;
import com.raulexposito.model.game.movement.Movement;

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