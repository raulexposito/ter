package com.raulexposito.model.game.checker.limitsreached;

import com.raulexposito.model.game.Counter;
import com.raulexposito.model.game.Movements;
import com.raulexposito.model.game.checker.LimitsReachedChecker;
import com.raulexposito.model.game.counter.CounterFixture;
import com.raulexposito.model.game.movements.MovementsFixture;
import com.raulexposito.model.game.result.Result;
import com.raulexposito.model.player.Player;
import com.raulexposito.model.player.fake.DoNothingPlayer;
import org.junit.Test;

import java.util.Optional;

import static com.google.common.truth.Truth.assertThat;
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
        assertThat(gameResult.isPresent()).isTrue();
        assertThat(gameResult.get().isDrawn()).isTrue();
        assertThat(gameResult.get().isVictory()).isFalse();
        assertThat(gameResult.get().getWinner().isPresent()).isFalse();
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
        assertThat(gameResult.isPresent()).isTrue();
        assertThat(gameResult.get().isDrawn()).isFalse();
        assertThat(gameResult.get().isVictory()).isTrue();
        assertThat(gameResult.get().getWinner().isPresent()).isTrue();
        assertThat(gameResult.get().getWinner().get()).isEqualTo(CIRCLE);
    }
}
