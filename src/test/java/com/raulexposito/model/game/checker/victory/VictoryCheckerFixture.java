package com.raulexposito.model.game.checker.victory;

import com.raulexposito.model.game.checker.VictoryChecker;

public interface VictoryCheckerFixture {

    default VictoryChecker createVictoryChecker() {
        return new VictoryChecker();
    }
}
