package com.raulexposito.model.game.game;

import com.raulexposito.model.board.Color;
import com.raulexposito.model.board.Placement;
import com.raulexposito.model.movement.Movement;
import com.raulexposito.model.player.Player;

import static com.raulexposito.model.board.Placement.*;

public class OnlyCenterPlayer extends Player {

    OnlyCenterPlayer(Color color) {
        super(color);
    }

    @Override
    public Movement move() {
        return add(CENTER);
    }
}