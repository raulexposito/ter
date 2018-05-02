package com.raulexposito.model.checker.victory;

import com.raulexposito.model.checker.VictoryChecker;

public interface VictoryCheckerFixture {

    default VictoryChecker createVictoryChecker() {
        return new VictoryChecker();
    }
}
