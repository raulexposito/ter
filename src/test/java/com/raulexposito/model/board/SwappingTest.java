package com.raulexposito.model.board;

import com.raulexposito.model.Board;
import org.junit.Assert;
import org.junit.Test;

import static com.raulexposito.model.Placement.*;
import static com.raulexposito.model.Color.BLACK;

public class SwappingTest implements BoardFixture {

    @Test
    public void boardCanSwapPositions() {
        // given
        Board board = createBoard();
        board = board
                .add(BLACK, TOP_LEFT)
                .add(BLACK, TOP_CENTER)
                .add(BLACK, TOP_RIGHT);
        // when
        board = board.swap(TOP_LEFT, CENTER);
        // then
        Assert.assertTrue(board.isPlacementEmpty(TOP_LEFT));
        Assert.assertTrue(board.isPlacementFilled(TOP_CENTER));
        Assert.assertTrue(board.isPlacementFilled(TOP_RIGHT));
        Assert.assertTrue(board.isPlacementFilled(CENTER));
    }
}