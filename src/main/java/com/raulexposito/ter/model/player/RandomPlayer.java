package com.raulexposito.ter.model.player;

import com.raulexposito.ter.model.board.Piece;
import com.raulexposito.ter.model.board.Placement;
import com.raulexposito.ter.model.movement.Movement;

import java.util.List;
import java.util.Random;
import java.util.UUID;

public class RandomPlayer extends Player {

    // ------------------------------------------------------------------------
    // CONSTRUCTOR
    // ------------------------------------------------------------------------

    public RandomPlayer(Piece piece) {
        super(piece, generateRandomName(piece));
    }

    // ------------------------------------------------------------------------
    // BUSINESS LOGIC
    // ------------------------------------------------------------------------

    @Override
    public Movement move() {
        if (canAdd()) {
            return add(anyEmptyPlacement());
        } else {
            return swap(anyOwnedPlacement(), anyEmptyPlacement());
        }
    }

    // ------------------------------------------------------------------------
    // PRIVATE METHODS
    // ------------------------------------------------------------------------

    private static String generateRandomName(Piece piece) {
        return "random-" + piece.name() + "-" + UUID.randomUUID().toString().substring(0, 8);
    }

    private Placement anyEmptyPlacement() {
        return getAny(emptySquares());
    }

    private Placement anyOwnedPlacement() {
        return getAny(mySquares());
    }

    private Placement getAny(List<Placement> placements) {
        return placements.get(new Random().nextInt(placements.size()));
    }
}
