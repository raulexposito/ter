package com.raulexposito.ter.fixture.game;

import com.raulexposito.ter.model.game.Movements;

public interface MovementsFixture {

    Integer NONE = 0;

    default Movements createUnlimitedSteps() {
        return Movements.upTo(Integer.MAX_VALUE);
    }

    default Movements createLimitedSteps(Integer maxSteps) {
        return Movements.upTo(maxSteps);
    }

    default Movements createReachedSteps() {
        return Movements.upTo(NONE);
    }
}
