package com.raulexposito.model.game.checker.swap;

import com.raulexposito.model.board.Board;
import com.raulexposito.model.Result;
import com.raulexposito.model.board.BoardFixture;
import com.raulexposito.model.game.checker.SwapChecker;
import org.junit.Assert;
import org.junit.Test;

import static com.raulexposito.model.board.Placement.*;
import static com.raulexposito.model.game.Color.*;

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