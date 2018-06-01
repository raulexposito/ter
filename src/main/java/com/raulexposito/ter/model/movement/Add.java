package com.raulexposito.ter.model.movement;

import com.raulexposito.ter.model.board.Board;
import com.raulexposito.ter.model.board.Piece;
import com.raulexposito.ter.model.board.Placement;
import com.raulexposito.ter.model.movement.check.AddChecker;

public class Add extends Movement {

    // ------------------------------------------------------------------------
    // CONSTANT VALUES
    // ------------------------------------------------------------------------

    private static final AddChecker CHECKER = new AddChecker();

    // ------------------------------------------------------------------------
    // ATTRIBUTES
    // ------------------------------------------------------------------------

    private final Placement placement;

    // ------------------------------------------------------------------------
    // CONSTRUCTOR
    // ------------------------------------------------------------------------

    public Add(Board board, Piece piece, Placement placement) {
        super(CHECKER.check(board, piece, placement), piece, board.add(piece,
                placement));
        this.placement = placement;
    }

    // ------------------------------------------------------------------------
    // PUBLIC METHODS
    // ------------------------------------------------------------------------

    @Override
    public String paramsAsJSON() {
        return "\"to\"" + ":" + "\"" + placement + "\"";
    }
}
