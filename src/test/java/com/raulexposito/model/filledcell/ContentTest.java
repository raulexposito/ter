package com.raulexposito.model.filledcell;

import static com.raulexposito.model.Color.BLACK;
import static com.raulexposito.model.Color.WHITE;

import com.raulexposito.model.cell.Cell;
import org.junit.Assert;
import org.junit.Test;

public class ContentTest implements FilledCellFixture {

    @Test
    public void blackChipMatch() {
        // given
        Cell cell = createBlackFilledCell();
        // when
        boolean result = cell.hasColor(BLACK);
        // then
        Assert.assertTrue(result);
    }

    @Test
    public void whiteChipMatch() {
        // given
        Cell cell = createWhiteFilledCell();
        // when
        boolean result = cell.hasColor(WHITE);
        // then
        Assert.assertTrue(result);
    }
}
