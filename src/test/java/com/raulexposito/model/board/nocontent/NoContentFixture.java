package com.raulexposito.model.board.nocontent;

import com.raulexposito.model.board.NoContent;

public interface NoContentFixture {

    default NoContent createNoContent(){
        return new NoContent();
    }
}
