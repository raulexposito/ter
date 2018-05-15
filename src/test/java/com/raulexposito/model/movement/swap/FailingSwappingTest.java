package com.raulexposito.model.movement.swap;

import com.raulexposito.model.board.Board;
import com.raulexposito.model.board.BoardFixture;
import com.raulexposito.model.movement.check.SwapChecker;
import com.raulexposito.model.movement.execution.Execution;
import org.junit.Assert;
import org.junit.Test;

import static com.raulexposito.model.board.Placement.*;
import static com.raulexposito.model.board.Placement.TOP_RIGHT;
import static com.raulexposito.model.board.Color.BLACK;
import static com.raulexposito.model.board.Color.WHITE;

public class FailingSwappingTest implements SwapCheckerFixture, BoardFixture {

    @Test
    public void minPiecesToSwapNotReached() {
        // given
        SwapChecker swapChecker = createSwapChecker();
        Board board = createBoard()
                .add(BLACK, TOP_LEFT)
                .add(BLACK, TOP_CENTER);
        // when
        Execution result = swapChecker.check(board, BLACK, TOP_LEFT, CENTER);
        // then
        Assert.assertEquals(Long.valueOf(2), board.howMany(BLACK));
        Assert.assertTrue(result.isFailed());
    }

    @Test
    public void onlyCanSwapMyColor() {
        // given
        SwapChecker swapChecker = createSwapChecker();
        Board board = createBoard()
                .add(BLACK, TOP_LEFT)
                .add(BLACK, TOP_CENTER)
                .add(BLACK, TOP_RIGHT)
                .add(WHITE, MIDDLE_LEFT)
                .add(WHITE, CENTER)
                .add(WHITE, MIDDLE_RIGHT);
        // when
        Execution result = swapChecker.check(board, WHITE, TOP_LEFT, BOTTOM_LEFT);
        // then
        Assert.assertTrue(result.isFailed());
    }

    @Test
    public void cannotSwapEmptySquares() {
        // given
        SwapChecker swapChecker = createSwapChecker();
        Board board = createBoard()
                .add(BLACK, TOP_LEFT)
                .add(BLACK, TOP_CENTER)
                .add(BLACK, TOP_RIGHT);
        // when
        Execution result = swapChecker.check(board, BLACK, BOTTOM_LEFT, BOTTOM_RIGHT);
        // then
        Assert.assertTrue(result.isFailed());
    }

    @Test
    public void cannotSwapFilledSquares() {
        // given
        SwapChecker swapChecker = createSwapChecker();
        Board board = createBoard()
                .add(BLACK, TOP_LEFT)
                .add(BLACK, TOP_CENTER)
                .add(BLACK, TOP_RIGHT);
        // when
        Execution result = swapChecker.check(board, BLACK, TOP_LEFT, TOP_RIGHT);
        // then
        Assert.assertTrue(result.isFailed());
    }
}
