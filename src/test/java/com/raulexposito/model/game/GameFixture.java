package com.raulexposito.model.game;

import com.raulexposito.model.game.checker.limitsreached.LimitsReachedCheckerFixture;

@Deprecated
public interface GameFixture extends PlayerFixture, LimitsReachedCheckerFixture {

    default Game createGame(){
        return new Game(createWhitePlayer(), createBlackPlayer(), createLimitsReachedChecker());
    }
}
