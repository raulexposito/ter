package com.raulexposito.ter.model.board;

public class NoContent implements Content {

    // ------------------------------------------------------------------------
    // CONSTANT VALUES
    // ------------------------------------------------------------------------

    public static final String EMPTY = "";

    // ------------------------------------------------------------------------
    // BUSINESS LOGIC
    // ------------------------------------------------------------------------

    @Override
    public boolean isFilled() {
        return false;
    }

    @Override
    public boolean hasPiece(Piece piece) {
        return false;
    }

    @Override
    public String toString() {
        return EMPTY;
    }
}
