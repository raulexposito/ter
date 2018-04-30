package com.raulexposito.model.emptycell;

import com.raulexposito.model.cell.EmptyCell;
import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

public class EmptinessTest implements EmptyCellFixture {

    @Test
    public void cellIsCreatedEmpty() {
        // when
        EmptyCell cell = createEmptyCell();
        // then
        Assert.assertTrue(cell.isEmpty());
    }

    @Test
    public void emptyCellCannotBeEmptied() {
        // given
        EmptyCell cell = createEmptyCell();
        // when
        Optional<EmptyCell> empty = cell.empty();
        // then
        Assert.assertTrue(!empty.isPresent());
    }
}
