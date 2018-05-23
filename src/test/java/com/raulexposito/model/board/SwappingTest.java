package com.raulexposito.model.board;

import org.junit.Assert;
import org.junit.Test;

import static com.raulexposito.model.board.Piece.CIRCLE;
import static com.raulexposito.model.board.Placement.*;

public class SwappingTest implements BoardFixture {

    @Test
    public void boardCanSwapPieces() {
        // given
        Board board = createBoard()
                .add(CIRCLE, TOP_LEFT)
                .add(CIRCLE, TOP_CENTER)
                .add(CIRCLE, TOP_RIGHT);

        // when
        board = board.swap(TOP_LEFT, CENTER);

        // then
        Assert.assertTrue(board.isEmpty(TOP_LEFT));
        Assert.assertTrue(board.isFilled(TOP_CENTER));
        Assert.assertTrue(board.isFilled(TOP_RIGHT));
        Assert.assertTrue(board.isFilled(CENTER));
    }
}