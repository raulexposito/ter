package com.raulexposito.model.emptycell;

import com.raulexposito.model.cell.EmptyCell;
import com.raulexposito.model.cell.FilledCell;
import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

import static com.raulexposito.model.cell.Chip.BLACK;

public class FillingTest implements EmptyCellFixture {

    @Test
    public void emptyCellIsNotCreatedFilled() {
        // when
        EmptyCell cell = createEmptyCell();
        // then
        Assert.assertTrue(!cell.isFilled());
    }

    @Test
    public void emptyCellCanBeFilled() {
        // given
        EmptyCell cell = createEmptyCell();
        // when
        Optional<FilledCell> filled = cell.fill(BLACK);
        // then
        Assert.assertTrue(filled.isPresent());
    }
}
