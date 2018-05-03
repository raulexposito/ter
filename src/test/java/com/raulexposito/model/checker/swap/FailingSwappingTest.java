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
    public void minSquaresToSwapNotReached() {
        // given
        SwapChecker swapChecker = createSwapChecker();
        Board board = createBoard()
                .add(BLACK, TOP_LEFT)
                .add(BLACK, TOP_CENTER);
        // when
        Result result = swapChecker.check(board, BLACK, TOP_LEFT, CENTER);
        // then
        Assert.assertEquals(Integer.valueOf(2), board.howMany(BLACK));
        Assert.assertEquals(Result.FAILURE, result);
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
        Result result = swapChecker.check(board, WHITE, TOP_LEFT, BOTTOM_LEFT);
        // then
        Assert.assertEquals(Result.FAILURE, result);
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
        Result result = swapChecker.check(board, BLACK, BOTTOM_LEFT, BOTTOM_RIGHT);
        // then
        Assert.assertEquals(Result.FAILURE, result);
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
        Result result = swapChecker.check(board, BLACK, TOP_LEFT, TOP_RIGHT);
        // then
        Assert.assertEquals(Result.FAILURE, result);
    }
}
