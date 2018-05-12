package com.raulexposito.model.game.checker.limitsreached;

import com.raulexposito.model.game.Counter;
import com.raulexposito.model.game.Steps;
import com.raulexposito.model.game.checker.LimitsReachedChecker;
import com.raulexposito.model.game.counter.CounterFixture;
import com.raulexposito.model.game.result.Result;
import com.raulexposito.model.game.steps.StepsFixture;
import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

import static com.raulexposito.model.Color.WHITE;

public class LimitsAreNoReachedTest implements LimitsReachedCheckerFixture, CounterFixture, StepsFixture {

    @Test
    public void noLimitIsReached () {
        // given
        LimitsReachedChecker checker = createLimitsReachedChecker();
        Counter counter = createCounter();
        Steps steps = createSteps();
        // when
        Optional<Result> gameResult = checker.limitsReached(WHITE, steps, counter);
        // then
        Assert.assertFalse(gameResult.isPresent());
    }
}
