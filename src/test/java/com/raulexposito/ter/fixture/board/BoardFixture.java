package com.raulexposito.ter.fixture.board;

import com.raulexposito.ter.model.board.Board;

public interface BoardFixture {

    default Board createBoard() {
        return Board.empty();
    }
}
