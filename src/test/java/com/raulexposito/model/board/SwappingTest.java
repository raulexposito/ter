package com.raulexposito.model.board;

import org.junit.Assert;
import org.junit.Test;

import static com.raulexposito.model.board.Placement.*;
import static com.raulexposito.model.Color.BLACK;

public class SwappingTest implements BoardFixture {

    @Test
    public void boardCanSwapPieces() {
        // given
        Board board = createBoard()
                .add(BLACK, TOP_LEFT)
                .add(BLACK, TOP_CENTER)
                .add(BLACK, TOP_RIGHT);
        // when
        board = board.swap(TOP_LEFT, CENTER);
        // then
        Assert.assertTrue(board.isEmpty(TOP_LEFT));
        Assert.assertTrue(board.isFilled(TOP_CENTER));
        Assert.assertTrue(board.isFilled(TOP_RIGHT));
        Assert.assertTrue(board.isFilled(CENTER));
    }
}