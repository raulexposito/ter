package com.raulexposito.model.filledsquare;

import com.raulexposito.model.square.FilledSquare;

import static com.raulexposito.model.Color.*;

public interface FilledSquareFixture {

    default FilledSquare createBlackFilledCell(){
        return new FilledSquare(BLACK);
    }

    default FilledSquare createWhiteFilledCell(){
        return new FilledSquare(WHITE);
    }
}
