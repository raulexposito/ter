package com.raulexposito.model.movement.swap;

import com.raulexposito.model.board.Board;
import com.raulexposito.model.board.BoardFixture;
import com.raulexposito.model.movement.check.SwapChecker;
import com.raulexposito.model.movement.execution.Execution;
import org.junit.Assert;
import org.junit.Test;

import static com.raulexposito.model.board.Piece.CIRCLE;
import static com.raulexposito.model.board.Piece.CROSS;
import static com.raulexposito.model.board.Placement.*;

public class FailingSwappingTest implements SwapCheckerFixture, BoardFixture {

    @Test
    public void minPiecesToSwapNotReached() {
        // given
        SwapChecker swapChecker = createSwapChecker();
        Board board = createBoard()
                .add(CIRCLE, TOP_LEFT)
                .add(CIRCLE, TOP_CENTER);
        // when
        Execution result = swapChecker.check(board, CIRCLE, TOP_LEFT, CENTER);
        // then
        Assert.assertEquals(Long.valueOf(2), board.howMany(CIRCLE));
        Assert.assertTrue(result.isFailed());
    }

    @Test
    public void onlyCanSwapMyPieces() {
        // given
        SwapChecker swapChecker = createSwapChecker();
        Board board = createBoard()
                .add(CIRCLE, TOP_LEFT)
                .add(CIRCLE, TOP_CENTER)
                .add(CIRCLE, TOP_RIGHT)
                .add(CROSS, MIDDLE_LEFT)
                .add(CROSS, CENTER)
                .add(CROSS, MIDDLE_RIGHT);
        // when
        Execution result = swapChecker.check(board, CROSS, TOP_LEFT, BOTTOM_LEFT);
        // then
        Assert.assertTrue(result.isFailed());
    }

    @Test
    public void cannotSwapEmptySquares() {
        // given
        SwapChecker swapChecker = createSwapChecker();
        Board board = createBoard()
                .add(CIRCLE, TOP_LEFT)
                .add(CIRCLE, TOP_CENTER)
                .add(CIRCLE, TOP_RIGHT);
        // when
        Execution result = swapChecker.check(board, CIRCLE, BOTTOM_LEFT, BOTTOM_RIGHT);
        // then
        Assert.assertTrue(result.isFailed());
    }

    @Test
    public void cannotSwapFilledSquares() {
        // given
        SwapChecker swapChecker = createSwapChecker();
        Board board = createBoard()
                .add(CIRCLE, TOP_LEFT)
                .add(CIRCLE, TOP_CENTER)
                .add(CIRCLE, TOP_RIGHT);
        // when
        Execution result = swapChecker.check(board, CIRCLE, TOP_LEFT, TOP_RIGHT);
        // then
        Assert.assertTrue(result.isFailed());
    }
}
