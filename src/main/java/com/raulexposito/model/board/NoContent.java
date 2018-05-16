package com.raulexposito.model.board;

public class NoContent implements Content {

    public static final String EMPTY = "";

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
