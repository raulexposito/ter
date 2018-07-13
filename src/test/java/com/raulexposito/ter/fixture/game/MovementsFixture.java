package com.raulexposito.ter.fixture.game;

import com.raulexposito.ter.model.game.Movements;

public interface MovementsFixture {

    Integer NONE = 0;

    default Movements createUnlimitedMovements() {
        return Movements.upTo(Integer.MAX_VALUE);
    }

    default Movements createLimitedMovements(Integer maxMovements) {
        return Movements.upTo(maxMovements);
    }

    default Movements createReachedMovements() {
        return Movements.upTo(NONE);
    }
}
