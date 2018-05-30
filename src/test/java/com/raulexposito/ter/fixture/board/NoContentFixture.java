package com.raulexposito.ter.fixture.board;

import com.raulexposito.ter.model.board.NoContent;

public interface NoContentFixture {

    default NoContent createNoContent() {
        return new NoContent();
    }
}
