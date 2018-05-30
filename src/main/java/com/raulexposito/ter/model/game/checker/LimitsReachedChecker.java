package com.raulexposito.ter.model.game.checker;

import com.raulexposito.ter.model.board.Piece;
import com.raulexposito.ter.model.game.Counter;
import com.raulexposito.ter.model.game.Movements;
import com.raulexposito.ter.model.game.result.Drawn;
import com.raulexposito.ter.model.game.result.Result;
import com.raulexposito.ter.model.game.result.Victory;
import com.raulexposito.ter.model.player.Player;

import java.util.Optional;

public class LimitsReachedChecker {

    public Optional<Result> limitsReached(Piece piece, Movements movements, Counter attempts, Player cross, Player circle) {
        if (movements.limitReached()) {
            return Optional.of(new Drawn(movements, cross, circle));
        }

        if (attempts.limitReached()) {
            return Optional.of(new Victory(movements, piece.getOpposite(), cross, circle));
        }

        return Optional.empty();
    }
}
