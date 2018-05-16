package com.raulexposito.model.game.checker.limitsreached;

import com.raulexposito.model.game.Counter;
import com.raulexposito.model.game.Movements;
import com.raulexposito.model.game.checker.LimitsReachedChecker;
import com.raulexposito.model.game.counter.CounterFixture;
import com.raulexposito.model.game.result.Result;
import com.raulexposito.model.game.movements.MovementsFixture;
import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

import static com.raulexposito.model.board.Piece.CROSS;

public class LimitsAreNoReachedTest implements LimitsReachedCheckerFixture, CounterFixture, MovementsFixture {

    @Test
    public void noLimitIsReached () {
        // given
        LimitsReachedChecker checker = createLimitsReachedChecker();
        Counter counter = createCounter();
        Movements movements = createUnlimitedSteps();
        // when
        Optional<Result> gameResult = checker.limitsReached(CROSS, movements, counter);
        // then
        Assert.assertFalse(gameResult.isPresent());
    }
}
