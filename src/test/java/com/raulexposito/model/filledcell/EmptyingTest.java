package com.raulexposito.model.filledcell;

import com.raulexposito.model.cell.Cell;
import com.raulexposito.model.cell.EmptyCell;
import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

import static com.raulexposito.model.cell.Chip.*;

public class EmptyingTest implements FilledCellFixture {

    @Test
    public void cellIsNotCreatedEmpty() {
        // when
        Cell cell = createBlackFilledCell();
        // then
        Assert.assertTrue(!cell.isEmpty());
    }

    @Test
    public void cellCanBeEmptied() {
        // given
        Cell cell = createBlackFilledCell();
        // when
        Optional<EmptyCell> empty = cell.empty();
        // then
        Assert.assertTrue(empty.isPresent());
    }
}
