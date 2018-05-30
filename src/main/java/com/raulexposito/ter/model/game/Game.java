package com.raulexposito.ter.model.game;

import com.raulexposito.ter.model.board.Board;
import com.raulexposito.ter.model.board.Piece;
import com.raulexposito.ter.model.game.checker.LimitsReachedChecker;
import com.raulexposito.ter.model.game.result.Result;
import com.raulexposito.ter.model.game.result.Victory;
import com.raulexposito.ter.model.movement.Movement;
import com.raulexposito.ter.model.player.Player;

import java.util.HashMap;
import java.util.Map;

import static com.raulexposito.ter.model.board.Piece.CIRCLE;
import static com.raulexposito.ter.model.board.Piece.CROSS;

public class Game {

    // ------------------------------------------------------------------------
    // CONSTANT VALUES
    // ------------------------------------------------------------------------

    private static final Integer MAX_ATTEMPTS = 20;
    private static final Integer MAX_STEPS = 1000;

    // ------------------------------------------------------------------------
    // ATTRIBUTES
    // ------------------------------------------------------------------------

    private final Map<Piece, Player> players = new HashMap<>();
    private final LimitsReachedChecker checker = new LimitsReachedChecker();

    // ------------------------------------------------------------------------
    // CONSTRUCTOR
    // ------------------------------------------------------------------------

    public Game(Player cross, Player circle) {
        this.players.put(CROSS, cross);
        this.players.put(CIRCLE, circle);
    }

    // ------------------------------------------------------------------------
    // BUSINESS LOGIC
    // ------------------------------------------------------------------------

    public Result play() {
        return play(Board.empty(), Movements.upTo(MAX_STEPS), CROSS, Counter.upTo(MAX_ATTEMPTS));
    }

    // ------------------------------------------------------------------------
    // PRIVATE METHODS
    // ------------------------------------------------------------------------

    private Result play(Board board, Movements movements, Piece piece, Counter attempts) {
        return checker.limitsReached(piece, movements, attempts, crossPlayer(), circlePlayer()).orElseGet(() -> {
            final Movement movement = players.get(piece).move(board);
            final Movements currentMovements = movements.add(movement);

            if (movement.isVictory()) {
                return new Victory(currentMovements, piece, crossPlayer(), circlePlayer());
            }

            if (movement.isFailed()) {
                return play(board, movements, piece, attempts.increase());
            }

            return play(movement.getBoard(), currentMovements, piece.getOpposite(), attempts.reset());
        });
    }

    private Player crossPlayer() {
        return players.get(CROSS);
    }

    private Player circlePlayer() {
        return players.get(CIRCLE);
    }
}
