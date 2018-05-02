package com.raulexposito.model.board;

import com.raulexposito.model.Board;

public interface BoardFixture {

    default Board createBoard(){
        return Board.empty();
    }
}
