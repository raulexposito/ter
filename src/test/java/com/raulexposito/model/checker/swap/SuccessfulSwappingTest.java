package com.raulexposito.model.checker.swap;

import com.raulexposito.model.Board;
import com.raulexposito.model.Result;
import com.raulexposito.model.board.BoardFixture;
import com.raulexposito.model.checker.SwapChecker;
import org.junit.Assert;
import org.junit.Test;

import static com.raulexposito.model.Placement.*;
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
        Result result = swapChecker.check(board, BLACK, TOP_LEFT, CENTER);
        // then
        Assert.assertEquals(Result.VALID, result);
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
        Result result = swapChecker.check(board, BLACK, CENTER, TOP_LEFT);
        // then
        Assert.assertEquals(Result.VALID, result);
    }
}
