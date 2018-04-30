package com.raulexposito.model.filledcell;

import static com.raulexposito.model.cell.Chip.BLACK;
import static com.raulexposito.model.cell.Chip.WHITE;

import com.raulexposito.model.cell.Cell;
import com.raulexposito.model.cell.EmptyCell;
import com.raulexposito.model.cell.FilledCell;
import org.junit.Assert;
import org.junit.Test;

public class ContentTest implements FilledCellFixture {

    @Test
    public void blackChipMatch() {
        // given
        Cell cell = createBlackFilledCell();
        // when
        boolean chip = cell.isChip(BLACK);
        // then
        Assert.assertTrue(chip);
    }

    @Test
    public void whiteChipMatch() {
        // given
        Cell cell = createWhiteFilledCell();
        // when
        boolean chip = cell.isChip(WHITE);
        // then
        Assert.assertTrue(chip);
    }
}
