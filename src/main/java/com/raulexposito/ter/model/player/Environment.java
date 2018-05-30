package com.raulexposito.ter.model.player;

import com.raulexposito.ter.model.board.Board;
import com.raulexposito.ter.model.board.Piece;
import com.raulexposito.ter.model.board.Placement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Environment {

    // ------------------------------------------------------------------------
    // CONSTANTS
    // ------------------------------------------------------------------------

    private static final Integer MAX_SAME_PIECES = 3;
    private static final Integer BOARD_SIZE = 9;

    // ------------------------------------------------------------------------
    // ATTRIBUTES
    // ------------------------------------------------------------------------

    private final List<Placement> mine = new ArrayList<>(MAX_SAME_PIECES);
    private final List<Placement> rival = new ArrayList<>(MAX_SAME_PIECES);
    private final List<Placement> empty = new ArrayList<>(BOARD_SIZE);

    // ------------------------------------------------------------------------
    // CONSTRUCTOR
    // ------------------------------------------------------------------------

    Environment(Board board, Piece piece) {
        Arrays.stream(Placement.values()).forEach(placement -> {
            if (board.isEmpty(placement)) {
                empty.add(placement);
            } else if (board.hasPiece(placement, piece)) {
                mine.add(placement);
            } else {
                rival.add(placement);
            }
        });
    }

    // ------------------------------------------------------------------------
    // PRIVATE METHODS
    // ------------------------------------------------------------------------

    boolean canAdd() {
        return mine.size() < MAX_SAME_PIECES;
    }

    List<Placement> mySquares() {
        return new ArrayList<>(mine);
    }

    List<Placement> rivalSquares() {
        return new ArrayList<>(rival);
    }

    List<Placement> emptySquares() {
        return new ArrayList<>(empty);
    }
}
