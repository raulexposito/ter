package com.raulexposito.ter.fixture.game.result;

import com.raulexposito.ter.fixture.game.StepFixture;
import com.raulexposito.ter.model.game.result.Victory;
import com.raulexposito.ter.fixture.player.fake.FakeOnlyCenterPlayer;

import static com.raulexposito.ter.model.board.Piece.CIRCLE;
import static com.raulexposito.ter.model.board.Piece.CROSS;

public interface VictoryFixture extends StepFixture {

    default Victory createVictory() {
        return new Victory(createUnlimitedStep(), CROSS, new FakeOnlyCenterPlayer(CROSS), new FakeOnlyCenterPlayer(CIRCLE));
    }
}
