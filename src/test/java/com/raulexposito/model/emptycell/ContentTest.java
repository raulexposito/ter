package com.raulexposito.model.emptycell;

import com.raulexposito.model.cell.EmptyCell;
import org.junit.Assert;
import org.junit.Test;

import static com.raulexposito.model.Color.*;

public class ContentTest implements EmptyCellFixture {

    @Test
    public void emptyCellCannotIncludeBlackChip() {
        // given
        EmptyCell cell = createEmptyCell();
        // when
        boolean result = cell.hasColor(BLACK);
        // then
        Assert.assertFalse(result);
    }

    @Test
    public void emptyCellCannotIncludeWhiteChip() {
        // given
        EmptyCell cell = createEmptyCell();
        // when
        boolean result = cell.hasColor(WHITE);
        // then
        Assert.assertFalse(result);
    }
}
