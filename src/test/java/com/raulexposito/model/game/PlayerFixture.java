package com.raulexposito.model.game;

import static com.raulexposito.model.Color.*;

@Deprecated
public interface PlayerFixture {

    default Player createWhitePlayer(){
        return new Player(WHITE);
    }

    default Player createBlackPlayer(){
        return new Player(BLACK);
    }
}
