package com.raulexposito.model.game.checker.limitsreached;

import com.raulexposito.model.game.checker.LimitsReachedChecker;

public interface LimitsReachedCheckerFixture {

    default LimitsReachedChecker createLimitsReachedChecker() {
        return new LimitsReachedChecker();
    }
}
