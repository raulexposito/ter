package com.raulexposito.model.board;

public interface Content {

    // ------------------------------------------------------------------------
    // ABSTRACT METHODS
    // ------------------------------------------------------------------------

    boolean isFilled();

    boolean hasPiece(Piece piece);

    // ------------------------------------------------------------------------
    // BUSINESS LOGIC
    // ------------------------------------------------------------------------

    default boolean isEmpty() {
        return !isFilled();
    }
}
