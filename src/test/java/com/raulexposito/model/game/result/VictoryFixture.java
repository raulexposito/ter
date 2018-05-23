package com.raulexposito.model.game.result;

import com.raulexposito.model.game.movements.MovementsFixture;
import com.raulexposito.model.player.fake.DoNothingPlayer;

import static com.raulexposito.model.board.Piece.CIRCLE;
import static com.raulexposito.model.board.Piece.CROSS;

public interface VictoryFixture extends MovementsFixture {

    default Victory createVictory() {
        return new Victory(createUnlimitedSteps(), CROSS, new DoNothingPlayer(CROSS), new DoNothingPlayer(CIRCLE));
    }
}
