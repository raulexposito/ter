package com.raulexposito.model.emptysquare;

import com.raulexposito.model.square.EmptySquare;

public interface EmptySquareFixture {

    default EmptySquare createEmptyCell(){
        return new EmptySquare();
    }
}
