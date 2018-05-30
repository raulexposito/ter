package com.raulexposito.ter.fixture.board;

import com.raulexposito.ter.model.board.Filled;

import static com.raulexposito.ter.model.board.Piece.CIRCLE;
import static com.raulexposito.ter.model.board.Piece.CROSS;

public interface FilledFixture {

    default Filled createCircleFilled() {
        return new Filled(CIRCLE);
    }

    default Filled createCrossFilled() {
        return new Filled(CROSS);
    }
}
