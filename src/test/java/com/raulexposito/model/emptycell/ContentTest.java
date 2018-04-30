package com.raulexposito.model.emptycell;

import com.raulexposito.model.cell.EmptyCell;
import org.junit.Assert;
import org.junit.Test;

import static com.raulexposito.model.cell.Chip.*;

public class ContentTest implements EmptyCellFixture {

    @Test
    public void emptyCellCannotIncludeBlackChip() {
        // given
        EmptyCell cell = createEmptyCell();
        // when
        boolean chip = cell.isChip(BLACK);
        // then
        Assert.assertFalse(chip);
    }

    @Test
    public void emptyCellCannotIncludeWhiteChip() {
        // given
        EmptyCell cell = createEmptyCell();
        // when
        boolean chip = cell.isChip(WHITE);
        // then
        Assert.assertFalse(chip);
    }
}
