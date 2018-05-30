package com.raulexposito.ter.model.game.checker.limitsreachedchecker;

import com.raulexposito.ter.fixture.game.checker.LimitsReachedCheckerFixture;
import com.raulexposito.ter.model.game.Counter;
import com.raulexposito.ter.model.game.Movements;
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

public class LimitsAreNoReachedTest implements LimitsReachedCheckerFixture, CounterFixture, MovementsFixture {

    @Test
    public void noLimitIsReached() {
        // given
        LimitsReachedChecker checker = createLimitsReachedChecker();
        Counter counter = createCounter();
        Movements movements = createUnlimitedSteps();
        Player crossPlayer = new FakeOnlyCenterPlayer(CROSS);
        Player circlePlayer = new FakeOnlyCenterPlayer(CIRCLE);

        // when
        Optional<Result> gameResult = checker.limitsReached(CROSS, movements, counter, crossPlayer, circlePlayer);

        // then
        assertThat(gameResult.isPresent()).isFalse();
    }
}
