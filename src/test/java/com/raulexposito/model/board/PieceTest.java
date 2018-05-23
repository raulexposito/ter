package com.raulexposito.model.board;

import org.junit.Assert;
import org.junit.Test;

import static com.raulexposito.model.board.Piece.CIRCLE;
import static com.raulexposito.model.board.Piece.CROSS;

public class PieceTest {

    @Test
    public void circlesOppositeIsCross() {
        // given
        Piece piece = CIRCLE;

        // when
        Piece opposite = piece.getOpposite();

        // then
        Assert.assertEquals(CROSS, opposite);
    }

    @Test
    public void crossOppositeIsCircle() {
        // given
        Piece piece = CROSS;

        // when
        Piece opposite = piece.getOpposite();

        // then
        Assert.assertEquals(CIRCLE, opposite);
    }
}
