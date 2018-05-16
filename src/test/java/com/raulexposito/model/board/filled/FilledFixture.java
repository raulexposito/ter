package com.raulexposito.model.board.filled;

import com.raulexposito.model.board.Filled;

import static com.raulexposito.model.board.Piece.CIRCLE;
import static com.raulexposito.model.board.Piece.CROSS;

public interface FilledFixture {

    default Filled createCircleFilled(){
        return new Filled(CIRCLE);
    }

    default Filled createCrossFilled(){
        return new Filled(CROSS);
    }
}
