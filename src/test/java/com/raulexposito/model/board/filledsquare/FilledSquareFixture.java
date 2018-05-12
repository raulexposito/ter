package com.raulexposito.model.board.filledsquare;

import com.raulexposito.model.board.FilledSquare;

import static com.raulexposito.model.game.Color.*;

public interface FilledSquareFixture {

    default FilledSquare createBlackFilledCell(){
        return new FilledSquare(BLACK);
    }

    default FilledSquare createWhiteFilledCell(){
        return new FilledSquare(WHITE);
    }
}
