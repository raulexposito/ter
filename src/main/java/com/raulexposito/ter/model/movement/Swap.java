package com.raulexposito.ter.model.movement;

import com.raulexposito.ter.model.board.Board;
import com.raulexposito.ter.model.board.Piece;
import com.raulexposito.ter.model.board.Placement;
import com.raulexposito.ter.model.movement.check.SwapChecker;

public class Swap extends Movement {

    private static final SwapChecker CHECKER = new SwapChecker();

    private final Placement current;

    private final Placement candidate;

    public Swap(Board board, Piece piece, Placement current, Placement candidate) {
        super(CHECKER.check(board, piece, current, candidate), piece, board.swap(
                current, candidate));
        this.current = current;
        this.candidate = candidate;
    }

    @Override
    public String paramsAsJSON() {
        return "\"from\"" + ":" + "\"" + current + "\", \"to\"" + ":" + "\"" + candidate + "\"";
    }
}
