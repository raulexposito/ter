package com.raulexposito.model.game.checker;

import com.raulexposito.model.Color;
import com.raulexposito.model.game.Counter;
import com.raulexposito.model.game.GameResult;
import com.raulexposito.model.game.Steps;

import java.util.Optional;

import static com.raulexposito.model.Color.WHITE;

public class LimitsReachedChecker {

    public Optional<GameResult> limitsReached(Color color, Steps steps, Counter attempts) {
        if (steps.limitReached()) {
            // TODO: empate
            return Optional.of(new GameResult(steps, WHITE));
        }

        if (attempts.limitReached()) {
            return Optional.of(new GameResult(steps, color.getOpposite()));
        }

        return Optional.empty();
    }
}
