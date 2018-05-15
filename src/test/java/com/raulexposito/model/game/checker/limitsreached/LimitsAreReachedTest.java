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

import static com.raulexposito.model.board.Color.*;

public class LimitsAreReachedTest implements LimitsReachedCheckerFixture, CounterFixture, StepsFixture {

    @Test
    public void stepsLimitIsReached () {
        // given
        LimitsReachedChecker checker = createLimitsReachedChecker();
        Counter counter = createCounter();
        // when
        Steps steps = createReachedSteps();
        Optional<Result> gameResult = checker.limitsReached(WHITE, steps, counter);
        // then
        Assert.assertTrue(gameResult.isPresent());
        Assert.assertTrue(gameResult.get().isDraw());
        Assert.assertFalse(gameResult.get().isVictory());
        Assert.assertFalse(gameResult.get().getWinner().isPresent());
    }

    @Test
    public void counterLimitIsReached () {
        // given
        LimitsReachedChecker checker = createLimitsReachedChecker();
        Steps steps = createUnlimitedSteps();
        // when
        Counter counter = createReachedCounter();
        Optional<Result> gameResult = checker.limitsReached(WHITE, steps, counter);
        // then
        Assert.assertTrue(gameResult.isPresent());
        Assert.assertFalse(gameResult.get().isDraw());
        Assert.assertTrue(gameResult.get().isVictory());
        Assert.assertTrue(gameResult.get().getWinner().isPresent());
        Assert.assertEquals(BLACK, gameResult.get().getWinner().get());
    }
}
