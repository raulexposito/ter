package com.raulexposito.ter.model.game;

import com.raulexposito.ter.model.board.Board;
import com.raulexposito.ter.model.board.Piece;
import com.raulexposito.ter.model.movement.Movement;

import static com.raulexposito.ter.model.board.Piece.CROSS;

public class Step {

    // --------------------------------------------------------------------
    // ATTRIBUTES
    // --------------------------------------------------------------------

    private final Board board;
    private final Movements movements;
    private final Piece piece;
    private final Counter attempts;

    // --------------------------------------------------------------------
    // CONSTRUCTORS
    // --------------------------------------------------------------------

    public Step(Movements movements, Counter counter) {
        this(Board.empty(), movements, CROSS, counter);
    }

    private Step(Board board, Movements movements, Piece piece, Counter attempts) {
        this.board = board;
        this.movements = movements;
        this.piece = piece;
        this.attempts = attempts;
    }

    // --------------------------------------------------------------------
    // BUSINESS LOGIC
    // --------------------------------------------------------------------

    Step next(Movement movement) {
        return new Step(movement.getBoard(), movements.add(movement), piece.getOpposite(), attempts.reset());
    }

    Step add(Movement movement) {
        return new Step(movement.getBoard(), movements.add(movement), piece, attempts.reset());
    }

    Step retry() {
        return new Step(board, movements, piece, attempts.increase());
    }

    public boolean isMovementsLimitReached() {
        return movements.limitReached();
    }

    public boolean isAttemptsLimitReached() {
        return attempts.limitReached();
    }

    // --------------------------------------------------------------------
    // GETTERS
    // --------------------------------------------------------------------

    public Movements getMovements() {
        return movements;
    }

    public Piece getCurrentPiece () {
        return piece;
    }

    public Piece getOppositePiece () {
        return getCurrentPiece().getOpposite();
    }

    public Board getBoard() {
        return board;
    }
}
