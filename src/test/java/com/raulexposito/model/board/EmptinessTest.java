package com.raulexposito.model.board;

import com.raulexposito.model.Board;
import org.junit.Assert;
import org.junit.Test;

import static com.raulexposito.model.Placement.*;
import static com.raulexposito.model.cell.Chip.*;

public class EmptinessTest implements BoardFixture {

    @Test
    public void boardIsCreatedEmpty() {
        // when
        Board board = createBoard();
        // then
        Assert.assertTrue(board.isEmpty());
    }

    @Test
    public void boardIsntEmptyAfterPutting() {
        // given
        Board board = createBoard();
        // when
        board.add(BLACK, CENTER);
        // then
        Assert.assertFalse(board.isEmpty());
    }
}
