package com.raulexposito.model.game.checker;

import com.raulexposito.model.board.Board;
import com.raulexposito.model.board.Piece;
import com.raulexposito.model.board.Placement;

import java.util.stream.Stream;

import static com.raulexposito.model.board.Piece.CIRCLE;
import static com.raulexposito.model.board.Piece.CROSS;
import static com.raulexposito.model.board.Placement.*;

public class VictoryChecker {

    // ------------------------------------------------------------------------
    // ATTRIBUTES
    // ------------------------------------------------------------------------

    private final Board board;

    // ------------------------------------------------------------------------
    // CONSTRUCTOR
    // ------------------------------------------------------------------------

    public VictoryChecker(Board board) {
        this.board = board;
    }

    // ------------------------------------------------------------------------
    // BUSINESS LOGIC
    // ------------------------------------------------------------------------

    public boolean isVictory() {
        return winnerPositions(board, CROSS) || winnerPositions(board, CIRCLE);
    }

    // ------------------------------------------------------------------------
    // PRIVATE METHODS
    // ------------------------------------------------------------------------

    private boolean winnerPositions(Board board, Piece piece) {
        return topRow(board, piece) ||
                middleRow(board, piece) ||
                bottomRow(board, piece) ||
                leftColumn(board, piece) ||
                middleColumn(board, piece) ||
                rightColumn(board, piece) ||
                topLeftToBottomRight(board, piece) ||
                topRightToBottomLeft(board, piece);
    }

    private boolean topRow(Board board, Piece piece) {
        return check(board, piece, Stream.of(TOP_LEFT, TOP_CENTER, TOP_RIGHT));
    }

    private boolean middleRow(Board board, Piece piece) {
        return check(board, piece, Stream.of(MIDDLE_LEFT, CENTER, MIDDLE_RIGHT));
    }

    private boolean bottomRow(Board board, Piece piece) {
        return check(board, piece, Stream.of(BOTTOM_LEFT, BOTTOM_CENTER, BOTTOM_RIGHT));
    }

    private boolean leftColumn(Board board, Piece piece) {
        return check(board, piece, Stream.of(TOP_LEFT, MIDDLE_LEFT, BOTTOM_LEFT));
    }

    private boolean middleColumn(Board board, Piece piece) {
        return check(board, piece, Stream.of(TOP_CENTER, CENTER, BOTTOM_CENTER));
    }

    private boolean rightColumn(Board board, Piece piece) {
        return check(board, piece, Stream.of(TOP_RIGHT, MIDDLE_RIGHT, BOTTOM_RIGHT));
    }

    private boolean topLeftToBottomRight(Board board, Piece piece) {
        return check(board, piece, Stream.of(TOP_LEFT, CENTER, BOTTOM_RIGHT));
    }

    private boolean topRightToBottomLeft(Board board, Piece piece) {
        return check(board, piece, Stream.of(TOP_RIGHT, CENTER, BOTTOM_LEFT));
    }

    private boolean check(Board board, Piece piece, Stream<Placement> placements) {
        return placements.allMatch(placement -> board.hasPiece(placement, piece));
    }
}
