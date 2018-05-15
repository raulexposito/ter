package com.raulexposito.model.game.checker;

import com.raulexposito.model.board.Color;
import com.raulexposito.model.game.Counter;
import com.raulexposito.model.game.Steps;
import com.raulexposito.model.game.result.Draw;
import com.raulexposito.model.game.result.Result;
import com.raulexposito.model.game.result.Victory;

import java.util.Optional;

public class LimitsReachedChecker {

    public Optional<Result> limitsReached(Color color, Steps steps, Counter attempts) {
        if (steps.limitReached()) {
            return Optional.of(new Draw(steps));
        }

        if (attempts.limitReached()) {
            return Optional.of(new Victory(steps, color.getOpposite()));
        }

        return Optional.empty();
    }
}
