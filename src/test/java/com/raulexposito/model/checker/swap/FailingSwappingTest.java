package com.raulexposito.model.checker.swap;

import com.raulexposito.model.Board;
import com.raulexposito.model.Result;
import com.raulexposito.model.board.BoardFixture;
import com.raulexposito.model.checker.SwapChecker;
import org.junit.Assert;
import org.junit.Test;

import static com.raulexposito.model.Placement.*;
import static com.raulexposito.model.Placement.TOP_RIGHT;
import static com.raulexposito.model.Color.BLACK;
import static com.raulexposito.model.Color.WHITE;

public class FailingSwappingTest implements SwapCheckerFixture, BoardFixture {

    @Test
    public void cannotSwapDifferentColors() {
        // given
        SwapChecker swapChecker = createSwapChecker();
        Board board = createBoard()
                .add(BLACK, TOP_LEFT)
                .add(BLACK, TOP_CENTER)
                .add(BLACK, TOP_RIGHT);
        // when
        Result result = swapChecker.check(board, WHITE, TOP_LEFT, TOP_CENTER);
        // then
        Assert.assertEquals(Result.FAILURE, result);
    }

    @Test
    public void min3ColorsToSwap() {
        // given
        SwapChecker swapChecker = createSwapChecker();
        Board board = createBoard()
                .add(BLACK, TOP_LEFT)
                .add(BLACK, TOP_CENTER);
        // when
        Result result = swapChecker.check(board, BLACK, TOP_LEFT, CENTER);
        // then
        Assert.assertEquals(Integer.valueOf(2), board.count(BLACK));
        Assert.assertEquals(Result.FAILURE, result);
    }

    @Test
    public void emptyPlacementsCannotBeSwapped() {
        // given
        SwapChecker swapChecker = createSwapChecker();
        Board board = createBoard()
                .add(BLACK, TOP_LEFT)
                .add(BLACK, TOP_CENTER)
                .add(BLACK, TOP_RIGHT);
        // when
        Result result = swapChecker.check(board, BLACK, CENTER, BOTTOM_CENTER);
        // then
        Assert.assertEquals(Result.FAILURE, result);
    }

    @Test
    public void cannotSwapToFilledPlacements() {
        // given
        SwapChecker swapChecker = createSwapChecker();
        Board board = createBoard()
                .add(BLACK, TOP_LEFT)
                .add(BLACK, TOP_CENTER)
                .add(BLACK, TOP_RIGHT);
        // when
        Result result = swapChecker.check(board, BLACK, TOP_LEFT, TOP_RIGHT);
        // then
        Assert.assertEquals(Result.FAILURE, result);
    }
}
