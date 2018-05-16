package com.raulexposito.model.game;

import com.raulexposito.model.movement.Movement;

import java.util.ArrayList;
import java.util.List;

public class Movements {

    // ------------------------------------------------------------------------
    // ATTRIBUTES
    // ------------------------------------------------------------------------

    private final List<Movement> movements;

    private final Integer maxMovements;

    // ------------------------------------------------------------------------
    // CONSTRUCTOR
    // ------------------------------------------------------------------------

    private Movements(Integer maxMovements) {
        this.movements = new ArrayList<>();
        this.maxMovements = maxMovements;
    }

    private Movements(Integer maxMovements, List<Movement> movements) {
        this.movements = new ArrayList<>(movements);
        this.maxMovements = maxMovements;
    }

    public static Movements upTo(Integer maxSteps) {
        return new Movements(maxSteps);
    }

    // ------------------------------------------------------------------------
    // BUSINESS LOGIC
    // ------------------------------------------------------------------------

    public Movements add(Movement movement) {
        movements.add(movement);
        return new Movements(maxMovements, movements);
    }

    public boolean limitReached() {
        Counter counter = Counter.upTo(maxMovements);
        for (int i = 0; i < movements.size(); i++) {
            counter = counter.increase();
        }
        return counter.limitReached();
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
//        for (final Board board: movements) {
//            builder.append(board.toString());
//        }
        return builder.toString();
    }
}
