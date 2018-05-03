package com.raulexposito.model.emptysquare;

import com.raulexposito.model.square.EmptySquare;
import org.junit.Assert;
import org.junit.Test;

public class CreationTest implements EmptySquareFixture {

    @Test
    public void cellIsCreatedEmpty() {
        // when
        EmptySquare cell = createEmptyCell();
        // then
        Assert.assertTrue(cell.isEmpty());
    }

    @Test
    public void emptyCellIsNotCreatedFilled() {
        // when
        EmptySquare cell = createEmptyCell();
        // then
        Assert.assertFalse(cell.isFilled());
    }
}
