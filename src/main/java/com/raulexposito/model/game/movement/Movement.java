package com.raulexposito.model.game.movement;

import com.raulexposito.model.board.Board;
import com.raulexposito.model.Result;
import com.raulexposito.model.game.checker.VictoryChecker;

import static com.raulexposito.model.Result.*;

public abstract class Movement {

    // ------------------------------------------------------------------------
    // ATTRIBUTES
    // ------------------------------------------------------------------------

    private Board board;

    private Result result;

    // ------------------------------------------------------------------------
    // CONSTRUCTOR
    // ------------------------------------------------------------------------

    // TODO: esto deberia ser inmutable
    Movement(Result result, Board board) {
        if (result == FAILURE) {
            this.result = result;
        }
        if (result == VALID) {
            final VictoryChecker checker = new VictoryChecker();
            this.result = checker.check(board);
        }
        this.board = board;
    }

    // ------------------------------------------------------------------------
    // GETTERS
    // ------------------------------------------------------------------------

    public boolean isFailure() {
        return result == FAILURE;
    }

    public boolean isVictory() {
        return result== VICTORY;
    }

    public Board getBoard() {
        return board;
    }
}
