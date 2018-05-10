package com.raulexposito.model.game;

import com.raulexposito.model.board.Board;
import com.raulexposito.model.game.movement.Movement;

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
}
