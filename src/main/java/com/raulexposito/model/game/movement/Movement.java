package com.raulexposito.model.game.movement;

import com.raulexposito.model.board.Board;
import com.raulexposito.model.Result;

import static com.raulexposito.model.Result.FAILURE;
import static com.raulexposito.model.Result.VICTORY;

public abstract class Movement {

    // ------------------------------------------------------------------------
    // ATTRIBUTES
    // ------------------------------------------------------------------------

    private Board board;

    private Result result;

    // ------------------------------------------------------------------------
    // CONSTRUCTOR
    // ------------------------------------------------------------------------

    Movement(Result result, Board board) {
        this.result = result;
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
