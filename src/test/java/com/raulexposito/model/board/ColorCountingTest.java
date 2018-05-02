package com.raulexposito.model.board;

import com.raulexposito.model.Board;
import org.junit.Assert;
import org.junit.Test;

import static com.raulexposito.model.Placement.*;
import static com.raulexposito.model.Color.*;

public class ColorCountingTest implements BoardFixture {

    @Test
    public void countOneColorType() {
        // given
        Board board = createBoard();
        // when
        board = board
                .add(BLACK, TOP_CENTER)
                .add(BLACK, CENTER)
                .add(BLACK, BOTTOM_CENTER);
        // then
        Assert.assertEquals(Integer.valueOf(3), board.count(BLACK));
    }

    @Test
    public void countTwoColorsType() {
        // given
        Board board = createBoard();
        // when
        board = board
                .add(BLACK, TOP_LEFT)
                .add(WHITE ,TOP_CENTER)
                .add(WHITE, MIDDLE_LEFT)
                .add(WHITE, CENTER);
        // then
        Assert.assertEquals(Integer.valueOf(1), board.count(BLACK));
        Assert.assertEquals(Integer.valueOf(3), board.count(WHITE));
    }
}
