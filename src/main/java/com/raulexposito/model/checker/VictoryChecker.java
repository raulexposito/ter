package com.raulexposito.model.checker;

import com.raulexposito.model.Board;
import com.raulexposito.model.MovementResult;
import com.raulexposito.model.Placement;
import com.raulexposito.model.cell.Chip;

import java.util.stream.Stream;

import static com.raulexposito.model.Placement.*;
import static com.raulexposito.model.cell.Chip.*;

public class VictoryChecker {

    // ------------------------------------------------------------------------
    // BUSINESS LOGIC
    // ------------------------------------------------------------------------

    public MovementResult check (Board board) {
        if (checkPositions(board, WHITE) || checkPositions(board, BLACK)) {
            return MovementResult.VICTORY;
        }
        return MovementResult.CONTINUE;
    }

    // ------------------------------------------------------------------------
    // PRIVATE METHODS
    // ------------------------------------------------------------------------

    private boolean checkPositions (Board board, Chip chip) {
        return topRow(board, chip) ||
                middleRow(board, chip) ||
                bottomRow(board, chip) ||
                leftColumn(board, chip) ||
                middleColumn(board, chip) ||
                rightColumn(board, chip) ||
                topLeftToBottomRight(board, chip) ||
                topRightToBottomLeft(board, chip);
    }

    private boolean topRow (Board board, Chip chip) {
        return check(board, chip, Stream.of(TOP_LEFT, TOP_CENTER, TOP_RIGHT));
    }

    private boolean middleRow (Board board, Chip chip) {
        return check(board, chip, Stream.of(MIDDLE_LEFT, CENTER, MIDDLE_RIGHT));
    }

    private boolean bottomRow (Board board, Chip chip) {
        return check(board, chip, Stream.of(BOTTOM_LEFT, BOTTOM_CENTER, BOTTOM_RIGHT));
    }

    private boolean leftColumn (Board board, Chip chip) {
        return check(board, chip, Stream.of(TOP_LEFT, MIDDLE_LEFT, BOTTOM_LEFT));
    }

    private boolean middleColumn (Board board, Chip chip) {
        return check(board, chip, Stream.of(TOP_CENTER, CENTER, BOTTOM_CENTER));
    }

    private boolean rightColumn (Board board, Chip chip) {
        return check(board, chip, Stream.of(TOP_RIGHT, MIDDLE_RIGHT, BOTTOM_RIGHT));
    }

    private boolean topLeftToBottomRight(Board board, Chip chip) {
        return check(board, chip, Stream.of(TOP_LEFT, CENTER, BOTTOM_RIGHT));
    }

    private boolean topRightToBottomLeft(Board board, Chip chip) {
        return check(board, chip, Stream.of(TOP_RIGHT, CENTER, BOTTOM_LEFT));
    }

    private boolean check(Board board, Chip chip, Stream<Placement> placements) {
        return placements.allMatch(placement -> board.placementHasChip(placement, chip));
    }
}
