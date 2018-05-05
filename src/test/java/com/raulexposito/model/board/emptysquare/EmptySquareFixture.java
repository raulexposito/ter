package com.raulexposito.model.board.emptysquare;

import com.raulexposito.model.board.EmptySquare;

public interface EmptySquareFixture {

    default EmptySquare createEmptyCell(){
        return new EmptySquare();
    }
}
