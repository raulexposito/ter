package com.raulexposito.ter.model.game.checker;

import com.raulexposito.ter.model.game.Step;
import com.raulexposito.ter.model.game.result.Drawn;
import com.raulexposito.ter.model.game.result.Result;
import com.raulexposito.ter.model.game.result.Victory;
import com.raulexposito.ter.model.player.Player;

import java.util.Optional;

public class LimitsReachedChecker {

    // ------------------------------------------------------------------------
    // BUSINESS LOGIC
    // ------------------------------------------------------------------------

    public Optional<Result> limitReached(Step step, Player cross, Player circle) {
        if (step.isMovementsLimitReached()) {
            return Optional.of(new Drawn(step, cross, circle));
        }

        if (step.isAttemptsLimitReached()) {
            return Optional.of(new Victory(step, step.getOppositePiece(), cross, circle));
        }

        return Optional.empty();
    }
}
