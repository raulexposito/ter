package com.raulexposito.model.game.checker.limitsreached;

import com.raulexposito.model.game.Counter;
import com.raulexposito.model.game.GameResult;
import com.raulexposito.model.game.Steps;
import com.raulexposito.model.game.checker.LimitsReachedChecker;
import com.raulexposito.model.game.counter.CounterFixture;
import com.raulexposito.model.game.steps.StepsFixture;
import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

import static com.raulexposito.model.game.Color.*;

public class SomeLimitIsReachedTest implements LimitsReachedCheckerFixture, CounterFixture, StepsFixture {

    @Test
    public void stepsLimitIsReached () {
        // given
        LimitsReachedChecker checker = createLimitsReachedChecker();
        Counter counter = createCounter();
        Steps steps = createReachedSteps();
        // when
        Optional<GameResult> gameResult = checker.limitsReached(WHITE, steps, counter);
        // then
        // TODO: comprobar que sea un empate
        Assert.assertTrue(gameResult.isPresent());
    }

    @Test
    public void counterLimitIsReached () {
        // given
        LimitsReachedChecker checker = createLimitsReachedChecker();
        Counter counter = createReachedCounter();
        Steps steps = createSteps();
        // when
        Optional<GameResult> gameResult = checker.limitsReached(WHITE, steps, counter);
        // then
        Assert.assertTrue(gameResult.isPresent());
        Assert.assertEquals(BLACK, gameResult.get().getWinner());
    }
}
