package com.raulexposito.model.game.checker.limitsreached;

import com.raulexposito.model.game.Counter;
import com.raulexposito.model.game.Movements;
import com.raulexposito.model.game.checker.LimitsReachedChecker;
import com.raulexposito.model.game.counter.CounterFixture;
import com.raulexposito.model.game.movements.MovementsFixture;
import com.raulexposito.model.game.result.Result;
import com.raulexposito.model.player.Player;
import com.raulexposito.model.player.fake.DoNothingPlayer;
import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

import static com.raulexposito.model.board.Piece.CIRCLE;
import static com.raulexposito.model.board.Piece.CROSS;

public class LimitsAreReachedTest implements LimitsReachedCheckerFixture, CounterFixture, MovementsFixture {

    @Test
    public void stepsLimitIsReached() {
        // given
        LimitsReachedChecker checker = createLimitsReachedChecker();
        Counter counter = createCounter();
        Player crossPlayer = new DoNothingPlayer(CROSS);
        Player circlePlayer = new DoNothingPlayer(CIRCLE);

        // when
        Movements movements = createReachedSteps();
        Optional<Result> gameResult = checker.limitsReached(CROSS, movements, counter, crossPlayer, circlePlayer);

        // then
        Assert.assertTrue(gameResult.isPresent());
        Assert.assertTrue(gameResult.get().isDrawn());
        Assert.assertFalse(gameResult.get().isVictory());
        Assert.assertFalse(gameResult.get().getWinner().isPresent());
    }

    @Test
    public void counterLimitIsReached() {
        // given
        LimitsReachedChecker checker = createLimitsReachedChecker();
        Movements movements = createUnlimitedSteps();
        Player crossPlayer = new DoNothingPlayer(CROSS);
        Player circlePlayer = new DoNothingPlayer(CIRCLE);

        // when
        Counter counter = createReachedCounter();
        Optional<Result> gameResult = checker.limitsReached(CROSS, movements, counter, crossPlayer, circlePlayer);

        // then
        Assert.assertTrue(gameResult.isPresent());
        Assert.assertFalse(gameResult.get().isDrawn());
        Assert.assertTrue(gameResult.get().isVictory());
        Assert.assertTrue(gameResult.get().getWinner().isPresent());
        Assert.assertEquals(CIRCLE, gameResult.get().getWinner().get());
    }
}
