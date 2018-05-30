package com.raulexposito.ter.fixture.game.checker;

import com.raulexposito.ter.model.game.checker.LimitsReachedChecker;

public interface LimitsReachedCheckerFixture {

    default LimitsReachedChecker createLimitsReachedChecker() {
        return new LimitsReachedChecker();
    }
}
