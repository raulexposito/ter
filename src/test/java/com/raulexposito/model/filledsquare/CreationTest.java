package com.raulexposito.model.filledsquare;

import com.raulexposito.model.square.Square;
import org.junit.Assert;
import org.junit.Test;

public class CreationTest implements FilledSquareFixture {

    @Test
    public void cellIsNotCreatedEmpty() {
        // when
        Square square = createBlackFilledCell();
        // then
        Assert.assertFalse(square.isEmpty());
    }

    @Test
    public void filledCellIsCreatedFilled() {
        // when
        Square square = createBlackFilledCell();
        // then
        Assert.assertTrue(square.isFilled());
    }
}
