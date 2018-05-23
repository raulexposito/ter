package com.raulexposito.model.board;

import org.junit.Assert;
import org.junit.Test;

import static com.raulexposito.model.board.Piece.CIRCLE;
import static com.raulexposito.model.board.Piece.CROSS;
import static com.raulexposito.model.board.Placement.*;

public class PieceCountingTest implements BoardFixture {

    @Test
    public void countOnePieceType() {
        // given
        Board board = createBoard();

        // when
        board = board
                .add(CIRCLE, TOP_CENTER)
                .add(CIRCLE, CENTER)
                .add(CIRCLE, BOTTOM_CENTER);

        // then
        Assert.assertEquals(Long.valueOf(3), board.howMany(CIRCLE));
    }

    @Test
    public void countTwoPiecesType() {
        // given
        Board board = createBoard();

        // when
        board = board
                .add(CIRCLE, TOP_LEFT)
                .add(CROSS, TOP_CENTER)
                .add(CROSS, MIDDLE_LEFT)
                .add(CROSS, CENTER);

        // then
        Assert.assertEquals(Long.valueOf(1), board.howMany(CIRCLE));
        Assert.assertEquals(Long.valueOf(3), board.howMany(CROSS));
    }
}
