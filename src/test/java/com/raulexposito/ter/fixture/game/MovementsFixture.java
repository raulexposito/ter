package com.raulexposito.ter.fixture.game;

import com.raulexposito.ter.model.game.Movements;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public interface MovementsFixture {

    default Movements createUnlimitedSteps() {
        return Movements.upTo(Integer.MAX_VALUE);
    }

    default Movements createLimitedSteps(Integer maxSteps) {
        return Movements.upTo(maxSteps);
    }

    default Movements createReachedSteps() {
        Movements movements = mock(Movements.class);
        when(movements.limitReached()).thenReturn(true);
        return movements;
    }
}
