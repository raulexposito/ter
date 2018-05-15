package com.raulexposito.model.player;

import com.raulexposito.model.board.Placement;
import com.raulexposito.model.board.Color;
import com.raulexposito.model.movement.Movement;

import java.util.List;
import java.util.Random;

public class RandomPlayer extends Player {

    // ------------------------------------------------------------------------
    // CONSTRUCTOR
    // ------------------------------------------------------------------------

    public RandomPlayer(Color color) {
        super(color);
    }

    // ------------------------------------------------------------------------
    // BUSINESS LOGIC
    // ------------------------------------------------------------------------

    @Override
    public Movement move() {
        if (canAdd()) {
            return add(anyEmptyPlacement());
        }
        else {
            return swap(anyOwnedPlacement(), anyEmptyPlacement());
        }
    }

    // ------------------------------------------------------------------------
    // PRIVATE METHODS
    // ------------------------------------------------------------------------

    private Placement anyEmptyPlacement() {
        return getAny(emptySquares());
    }

    private Placement anyOwnedPlacement() {
        return getAny(mySquares());
    }

    private Placement getAny (List<Placement> placements) {
        return placements.get(new Random().nextInt(placements.size()));
    }
}
