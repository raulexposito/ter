package com.raulexposito.model.filledcell;

import com.raulexposito.model.cell.Cell;
import org.junit.Assert;
import org.junit.Test;

public class CreationTest implements FilledCellFixture {

    @Test
    public void cellIsNotCreatedEmpty() {
        // when
        Cell cell = createBlackFilledCell();
        // then
        Assert.assertTrue(!cell.isEmpty());
    }

    @Test
    public void filledCellIsCreatedFilled() {
        // when
        Cell cell = createBlackFilledCell();
        // then
        Assert.assertTrue(cell.isFilled());
    }
}
