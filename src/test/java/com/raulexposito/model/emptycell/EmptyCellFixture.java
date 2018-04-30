package com.raulexposito.model.emptycell;

import com.raulexposito.model.cell.EmptyCell;

public interface EmptyCellFixture {

    default EmptyCell createEmptyCell(){
        return new EmptyCell();
    }
}
