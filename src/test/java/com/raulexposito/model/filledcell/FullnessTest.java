package com.raulexposito.model.filledcell;

import com.raulexposito.model.cell.Cell;
import com.raulexposito.model.cell.FilledCell;
import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

import static com.raulexposito.model.cell.Chip.BLACK;

public class FullnessTest implements FilledCellFixture {

    @Test
    public void filledCellIsCreatedFilled() {
        // when
        Cell cell = createBlackFilledCell();
        // then
        Assert.assertTrue(cell.isFilled());
    }

    @Test
    public void filledCellCannotBeFilled() {
        // given
        Cell cell = createBlackFilledCell();
        // when
        Optional<FilledCell> filled = cell.fill(BLACK);
        // then
        Assert.assertTrue(!filled.isPresent());
    }
}
