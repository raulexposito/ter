package com.raulexposito.model.board;

import com.raulexposito.model.Board;
import org.junit.Assert;
import org.junit.Test;

import static com.raulexposito.model.Placement.*;
import static com.raulexposito.model.cell.Chip.*;

public class ChipsCountingTest implements BoardFixture {

    @Test
    public void countOneChipType() {
        // given
        Board board = createBoard();
        // when
        board.add(BLACK, TOP_CENTER);
        board.add(BLACK, CENTER);
        board.add(BLACK, BOTTOM_CENTER);
        // then
        Assert.assertEquals(Integer.valueOf(3), board.count(BLACK));
    }

    @Test
    public void countTwoChipTypes() {
        // given
        Board board = createBoard();
        // when
        board.add(BLACK, TOP_LEFT);
        board.add(WHITE ,TOP_CENTER);
        board.add(WHITE, MIDDLE_LEFT);
        board.add(WHITE, CENTER);
        // then
        Assert.assertEquals(Integer.valueOf(1), board.count(BLACK));
        Assert.assertEquals(Integer.valueOf(3), board.count(WHITE));
    }
}
