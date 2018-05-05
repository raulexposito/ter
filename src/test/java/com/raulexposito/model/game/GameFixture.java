package com.raulexposito.model.game;

@Deprecated
public interface GameFixture extends PlayerFixture {

    default Game createGame(){
        return new Game(createWhitePlayer(), createBlackPlayer());
    }
}
