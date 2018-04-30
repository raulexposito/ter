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
        board.put(BLACK, TOP_CENTER);
        board.put(BLACK, CENTER);
        board.put(BLACK, BOTTOM_CENTER);
        // then
        Assert.assertEquals(Integer.valueOf(3), board.count(BLACK));
    }

    @Test
    public void countTwoChipTypes() {
        // given
        Board board = createBoard();
        // when
        board.put(BLACK, TOP_LEFT);
        board.put(WHITE ,TOP_CENTER);
        board.put(WHITE, MIDDLE_LEFT);
        board.put(WHITE, CENTER);
        // then
        Assert.assertEquals(Integer.valueOf(1), board.count(BLACK));
        Assert.assertEquals(Integer.valueOf(3), board.count(WHITE));
    }
}
