package com.raulexposito.model.game;

import com.raulexposito.model.board.Board;
import com.raulexposito.model.movement.Movement;

import java.util.ArrayList;
import java.util.List;

public class Steps {

    // ------------------------------------------------------------------------
    // CONSTANT VALUES
    // ------------------------------------------------------------------------

	private static final Integer MAX_STEPS = 1000;

    // ------------------------------------------------------------------------
    // ATTRIBUTES
    // ------------------------------------------------------------------------

    private List<Board> steps;

    // ------------------------------------------------------------------------
    // CONSTRUCTOR
    // ------------------------------------------------------------------------

    private Steps() {
        this.steps = new ArrayList<>();
    }

    private Steps(List<Board> steps) {
        this.steps = new ArrayList<>(steps);
    }

    public static Steps empty() {
        return new Steps();
    }

    // ------------------------------------------------------------------------
    // BUSINESS LOGIC
    // ------------------------------------------------------------------------

    public Steps add(Movement movement) {
        steps.add(movement.getBoard());
        return new Steps(steps);
    }

    public boolean limitReached() {
        Counter counter = Counter.upTo(MAX_STEPS);
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
