package com.raulexposito.model.board;

import org.junit.Assert;
import org.junit.Test;

import static com.raulexposito.model.board.Placement.*;
import static com.raulexposito.model.game.Color.*;

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
        Assert.assertEquals(Long.valueOf(3), board.howMany(BLACK));
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
        Assert.assertEquals(Long.valueOf(1), board.howMany(BLACK));
        Assert.assertEquals(Long.valueOf(3), board.howMany(WHITE));
    }
}
