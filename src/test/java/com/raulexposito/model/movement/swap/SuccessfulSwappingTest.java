package com.raulexposito.model.movement.swap;

import com.raulexposito.model.board.Board;
import com.raulexposito.model.board.BoardFixture;
import com.raulexposito.model.movement.check.SwapChecker;
import com.raulexposito.model.movement.execution.Execution;
import org.junit.Assert;
import org.junit.Test;

import static com.raulexposito.model.board.Placement.*;
import static com.raulexposito.model.Color.*;

public class SuccessfulSwappingTest implements SwapCheckerFixture, BoardFixture {

    @Test
    public void myColorCanBeSwappedToEmpty() {
        // given
        SwapChecker swapChecker = createSwapChecker();
        Board board = createBoard()
                .add(BLACK, TOP_LEFT)
                .add(BLACK, TOP_CENTER)
                .add(BLACK, TOP_RIGHT);
        // when
        Execution result = swapChecker.check(board, BLACK, TOP_LEFT, CENTER);
        // then
        Assert.assertTrue(result.isValid());
    }

    @Test
    public void emptyCanBeSwappedToMyColor() {
        // given
        SwapChecker swapChecker = createSwapChecker();
        Board board = createBoard()
                .add(BLACK, TOP_LEFT)
                .add(BLACK, TOP_CENTER)
                .add(BLACK, TOP_RIGHT);
        // when
        Execution result = swapChecker.check(board, BLACK, CENTER, TOP_LEFT);
        // then
        Assert.assertTrue(result.isValid());
    }
}
