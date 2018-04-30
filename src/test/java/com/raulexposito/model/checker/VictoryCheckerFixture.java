package com.raulexposito.model.checker;

public interface VictoryCheckerFixture {

    default Checker createVictoryChecker() {
        return new VictoryChecker();
    }
}
