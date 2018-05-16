package com.raulexposito.model.board;

import org.junit.Assert;
import org.junit.Test;

import static com.raulexposito.model.board.Piece.CIRCLE;
import static com.raulexposito.model.board.Piece.CROSS;
import static com.raulexposito.model.board.Placement.CENTER;

public class EmptinessTest implements BoardFixture {

    @Test
    public void boardIsCreatedEmpty() {
        // when
        Board board = createBoard();
        // then
        Assert.assertEquals(Long.valueOf(0), board.howMany(CIRCLE));
        Assert.assertEquals(Long.valueOf(0), board.howMany(CROSS));
    }

    @Test
    public void boardIsNotEmptyAfterAdding() {
        // given
        Board board = createBoard();
        // when
        board = board.add(CIRCLE, CENTER);
        // then
        Assert.assertEquals(Long.valueOf(1), board.howMany(CIRCLE));
        Assert.assertEquals(Long.valueOf(0), board.howMany(CROSS));
    }
}
