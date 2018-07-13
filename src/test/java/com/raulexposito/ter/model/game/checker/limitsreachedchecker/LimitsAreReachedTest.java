package com.raulexposito.ter.model.game.checker.limitsreachedchecker;

import com.raulexposito.ter.fixture.game.StepFixture;
import com.raulexposito.ter.fixture.game.checker.LimitsReachedCheckerFixture;
import com.raulexposito.ter.model.game.Counter;
import com.raulexposito.ter.model.game.Movements;
import com.raulexposito.ter.model.game.Step;
import com.raulexposito.ter.model.game.checker.LimitsReachedChecker;
import com.raulexposito.ter.fixture.game.CounterFixture;
import com.raulexposito.ter.fixture.game.MovementsFixture;
import com.raulexposito.ter.model.game.result.Result;
import com.raulexposito.ter.model.player.Player;
import com.raulexposito.ter.fixture.player.fake.FakeOnlyCenterPlayer;
import org.junit.Test;

import java.util.Optional;

import static com.google.common.truth.Truth.assertThat;
import static com.raulexposito.ter.model.board.Piece.CIRCLE;
import static com.raulexposito.ter.model.board.Piece.CROSS;

public class LimitsAreReachedTest implements LimitsReachedCheckerFixture, CounterFixture, MovementsFixture, StepFixture {

    @Test
    public void stepsLimitIsReached() {
        // given
        LimitsReachedChecker checker = createLimitsReachedChecker();
        Movements movements = createReachedMovements();
        Counter counter = createCounter();
        Step step = createStep(movements, counter);
        Player crossPlayer = new FakeOnlyCenterPlayer(CROSS);
        Player circlePlayer = new FakeOnlyCenterPlayer(CIRCLE);

        // when
        Optional<Result> gameResult = checker.limitReached(step, crossPlayer, circlePlayer);

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
        Movements movements = createUnlimitedMovements();
        Counter counter = createReachedCounter();
        Step step = createStep(movements, counter);
        Player crossPlayer = new FakeOnlyCenterPlayer(CROSS);
        Player circlePlayer = new FakeOnlyCenterPlayer(CIRCLE);

        // when
        Optional<Result> gameResult = checker.limitReached(step, crossPlayer, circlePlayer);

        // then
        assertThat(gameResult.isPresent()).isTrue();
        assertThat(gameResult.get().isDrawn()).isFalse();
        assertThat(gameResult.get().isVictory()).isTrue();
        assertThat(gameResult.get().getWinner().isPresent()).isTrue();
        assertThat(gameResult.get().getWinner().get()).isEqualTo(CIRCLE);
    }
}
