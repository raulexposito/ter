package com.raulexposito.model.board;

public interface BoardFixture {

    default Board createBoard() {
        return Board.empty();
    }
}
