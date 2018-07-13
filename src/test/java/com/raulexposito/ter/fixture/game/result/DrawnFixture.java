package com.raulexposito.ter.fixture.game.result;

import com.raulexposito.ter.fixture.game.StepFixture;
import com.raulexposito.ter.model.game.result.Drawn;
import com.raulexposito.ter.fixture.player.fake.FakeOnlyCenterPlayer;

import static com.raulexposito.ter.model.board.Piece.CIRCLE;
import static com.raulexposito.ter.model.board.Piece.CROSS;

public interface DrawnFixture extends StepFixture {

    default Drawn createDrawn() {
        return new Drawn(createUnlimitedStep(), new FakeOnlyCenterPlayer(CROSS), new FakeOnlyCenterPlayer(CIRCLE));
    }
}
