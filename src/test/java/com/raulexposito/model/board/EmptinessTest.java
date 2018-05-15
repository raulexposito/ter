package com.raulexposito.model.board;

import org.junit.Assert;
import org.junit.Test;

import static com.raulexposito.model.board.Color.BLACK;
import static com.raulexposito.model.board.Color.WHITE;
import static com.raulexposito.model.board.Placement.CENTER;

public class EmptinessTest implements BoardFixture {

    @Test
    public void boardIsCreatedEmpty() {
        // when
        Board board = createBoard();
        // then
        Assert.assertEquals(Long.valueOf(0), board.howMany(BLACK));
        Assert.assertEquals(Long.valueOf(0), board.howMany(WHITE));
    }

    @Test
    public void boardIsNotEmptyAfterAdding() {
        // given
        Board board = createBoard();
        // when
        board = board.add(BLACK, CENTER);
        // then
        Assert.assertEquals(Long.valueOf(1), board.howMany(BLACK));
        Assert.assertEquals(Long.valueOf(0), board.howMany(WHITE));
    }
}
