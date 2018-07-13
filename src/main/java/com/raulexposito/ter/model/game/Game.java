package com.raulexposito.ter.model.game;

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

    private static final Integer MAX_MOVEMENTS = 1000;
    private static final Integer MAX_ATTEMPTS = 20;

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
        return play(new Step(Movements.upTo(MAX_MOVEMENTS), Counter.upTo(MAX_ATTEMPTS)));
    }

    // ------------------------------------------------------------------------
    // PRIVATE METHODS
    // ------------------------------------------------------------------------

    private Result play(Step step) {
        return checker.limitReached(step, crossPlayer(), circlePlayer()).orElseGet(() -> {
            final Movement movement = players.get(step.getCurrentPiece()).move(step.getBoard());

            if (movement.isVictory()) {
                return new Victory(step.add(movement), step.getCurrentPiece(), crossPlayer(), circlePlayer());
            }

            if (movement.isFailed()) {
                return play(step.retry());
            }

            return play(step.next(movement));
        });
    }

    private Player crossPlayer() {
        return players.get(CROSS);
    }

    private Player circlePlayer() {
        return players.get(CIRCLE);
    }
}
