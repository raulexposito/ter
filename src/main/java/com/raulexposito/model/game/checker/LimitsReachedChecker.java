package com.raulexposito.model.game.checker;

import com.raulexposito.model.board.Piece;
import com.raulexposito.model.game.Counter;
import com.raulexposito.model.game.Movements;
import com.raulexposito.model.game.result.Drawn;
import com.raulexposito.model.game.result.Result;
import com.raulexposito.model.game.result.Victory;

import java.util.Optional;

public class LimitsReachedChecker {

    public Optional<Result> limitsReached(Piece piece, Movements movements, Counter attempts) {
        if (movements.limitReached()) {
            return Optional.of(new Drawn(movements));
        }

        if (attempts.limitReached()) {
            return Optional.of(new Victory(movements, piece.getOpposite()));
        }

        return Optional.empty();
    }
}
