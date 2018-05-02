package com.raulexposito.model.checker.swap;

import com.raulexposito.model.Board;
import com.raulexposito.model.MovementResult;
import com.raulexposito.model.board.BoardFixture;
import com.raulexposito.model.checker.SwapChecker;
import org.junit.Assert;
import org.junit.Test;

import static com.raulexposito.model.Placement.*;
import static com.raulexposito.model.cell.Chip.*;

public class SuccessfulSwappingTest implements SwapCheckerFixture, BoardFixture {

    @Test
    public void chipsCanBeSwapped() {
        // given
        Board board = createBoard();
        SwapChecker swapChecker = createSwapChecker();
        board.add(BLACK, TOP_LEFT);
        board.add(BLACK, TOP_CENTER);
        board.add(BLACK, TOP_RIGHT);
        // when
        MovementResult result = swapChecker.check(board, BLACK, TOP_LEFT, CENTER);
        // then
        Assert.assertEquals(MovementResult.SUCCESS, result);
    }
}
