package com.raulexposito.model.filledcell;

import com.raulexposito.model.cell.FilledCell;

import static com.raulexposito.model.Color.*;

public interface FilledCellFixture {

    default FilledCell createBlackFilledCell(){
        return new FilledCell(BLACK);
    }

    default FilledCell createWhiteFilledCell(){
        return new FilledCell(WHITE);
    }
}
