package com.raulexposito.ter.fixture.game.result;

import com.raulexposito.ter.fixture.game.MovementsFixture;
import com.raulexposito.ter.model.game.result.Drawn;
import com.raulexposito.ter.fixture.player.fake.FakeOnlyCenterPlayer;

import static com.raulexposito.ter.model.board.Piece.CIRCLE;
import static com.raulexposito.ter.model.board.Piece.CROSS;

public interface DrawnFixture extends MovementsFixture {

    default Drawn createDrawn() {
        return new Drawn(createUnlimitedSteps(), new FakeOnlyCenterPlayer(CROSS), new FakeOnlyCenterPlayer(CIRCLE));
    }
}
