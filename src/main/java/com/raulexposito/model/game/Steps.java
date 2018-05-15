package com.raulexposito.model.game;

import com.raulexposito.model.board.Board;
import com.raulexposito.model.movement.Movement;

import java.util.ArrayList;
import java.util.List;

public class Steps {


    // ------------------------------------------------------------------------
    // ATTRIBUTES
    // ------------------------------------------------------------------------

    private final List<Board> steps;

    private final Integer maxSteps;

    // ------------------------------------------------------------------------
    // CONSTRUCTOR
    // ------------------------------------------------------------------------

    private Steps(Integer maxSteps) {
        this.steps = new ArrayList<>();
        this.maxSteps = maxSteps;
    }

    private Steps(Integer maxSteps, List<Board> steps) {
        this.steps = new ArrayList<>(steps);
        this.maxSteps = maxSteps;
    }

    public static Steps upTo(Integer maxSteps) {
        return new Steps(maxSteps);
    }

    // ------------------------------------------------------------------------
    // BUSINESS LOGIC
    // ------------------------------------------------------------------------

    public Steps add(Movement movement) {
        steps.add(movement.getBoard());
        return new Steps(maxSteps, steps);
    }

    public boolean limitReached() {
        Counter counter = Counter.upTo(maxSteps);
        for (int i = 0; i < steps.size(); i++) {
            counter = counter.increase();
        }
        return counter.limitReached();
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        for (final Board board: steps) {
            builder.append(board.toString());
        }
        return builder.toString();
    }
}
