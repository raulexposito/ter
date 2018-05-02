package com.raulexposito.model.emptycell;

import com.raulexposito.model.cell.EmptyCell;
import org.junit.Assert;
import org.junit.Test;

public class CreationTest implements EmptyCellFixture {

    @Test
    public void cellIsCreatedEmpty() {
        // when
        EmptyCell cell = createEmptyCell();
        // then
        Assert.assertTrue(cell.isEmpty());
    }

    @Test
    public void emptyCellIsNotCreatedFilled() {
        // when
        EmptyCell cell = createEmptyCell();
        // then
        Assert.assertTrue(!cell.isFilled());
    }
}
