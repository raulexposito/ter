package com.raulexposito.model.board;

public class Filled implements Content {

    // ------------------------------------------------------------------------
    // ATTRIBUTES
    // ------------------------------------------------------------------------

    private final Piece piece;

    // ------------------------------------------------------------------------
    // CONSTRUCTOR
    // ------------------------------------------------------------------------

    public Filled(Piece piece) {
        this.piece = piece;
    }

    // ------------------------------------------------------------------------
    // BUSINESS LOGIC
    // ------------------------------------------------------------------------

    @Override
    public boolean isFilled() {
        return true;
    }

    @Override
    public boolean hasPiece(Piece piece) {
        return this.piece == piece;
    }

    @Override
    public String toString() {
        return piece.toString();
    }
}
