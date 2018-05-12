package com.raulexposito.model.game.checker;

import com.raulexposito.model.board.Board;
import com.raulexposito.model.board.Placement;
import com.raulexposito.model.Color;

import java.util.stream.Stream;

import static com.raulexposito.model.board.Placement.*;
import static com.raulexposito.model.Color.*;

public class VictoryChecker {

    // ------------------------------------------------------------------------
    // BUSINESS LOGIC
    // ------------------------------------------------------------------------

    public boolean isVictory(Board board) {
        return winnerPositions(board, WHITE) || winnerPositions(board, BLACK);
    }

    // ------------------------------------------------------------------------
    // PRIVATE METHODS
    // ------------------------------------------------------------------------

    private boolean winnerPositions(Board board, Color color) {
        return topRow(board, color) ||
                middleRow(board, color) ||
                bottomRow(board, color) ||
                leftColumn(board, color) ||
                middleColumn(board, color) ||
                rightColumn(board, color) ||
                topLeftToBottomRight(board, color) ||
                topRightToBottomLeft(board, color);
    }

    private boolean topRow (Board board, Color color) {
        return check(board, color, Stream.of(TOP_LEFT, TOP_CENTER, TOP_RIGHT));
    }

    private boolean middleRow (Board board, Color color) {
        return check(board, color, Stream.of(MIDDLE_LEFT, CENTER, MIDDLE_RIGHT));
    }

    private boolean bottomRow (Board board, Color color) {
        return check(board, color, Stream.of(BOTTOM_LEFT, BOTTOM_CENTER, BOTTOM_RIGHT));
    }

    private boolean leftColumn (Board board, Color color) {
        return check(board, color, Stream.of(TOP_LEFT, MIDDLE_LEFT, BOTTOM_LEFT));
    }

    private boolean middleColumn (Board board, Color color) {
        return check(board, color, Stream.of(TOP_CENTER, CENTER, BOTTOM_CENTER));
    }

    private boolean rightColumn (Board board, Color color) {
        return check(board, color, Stream.of(TOP_RIGHT, MIDDLE_RIGHT, BOTTOM_RIGHT));
    }

    private boolean topLeftToBottomRight(Board board, Color color) {
        return check(board, color, Stream.of(TOP_LEFT, CENTER, BOTTOM_RIGHT));
    }

    private boolean topRightToBottomLeft(Board board, Color color) {
        return check(board, color, Stream.of(TOP_RIGHT, CENTER, BOTTOM_LEFT));
    }

    private boolean check(Board board, Color color, Stream<Placement> placements) {
        return placements.allMatch(placement -> board.hasColor(placement, color));
    }
}
