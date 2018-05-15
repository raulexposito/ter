package com.raulexposito.model.board.filled;

import com.raulexposito.model.board.Filled;

import static com.raulexposito.model.board.Color.BLACK;
import static com.raulexposito.model.board.Color.WHITE;

public interface FilledFixture {

    default Filled createBlackFilled(){
        return new Filled(BLACK);
    }

    default Filled createWhiteFilled(){
        return new Filled(WHITE);
    }
}
