package com.raulexposito.model.movement.swap;

import com.raulexposito.model.board.Board;
import com.raulexposito.model.board.BoardFixture;
import com.raulexposito.model.movement.check.SwapChecker;
import com.raulexposito.model.movement.execution.Execution;
import org.junit.Assert;
import org.junit.Test;

import static com.raulexposito.model.board.Piece.CIRCLE;
import static com.raulexposito.model.board.Placement.*;

public class SuccessfulSwappingTest implements SwapCheckerFixture, BoardFixture {

    @Test
    public void myPieceCanBeSwappedToEmpty() {
        // given
        SwapChecker swapChecker = createSwapChecker();
        Board board = createBoard()
                .add(CIRCLE, TOP_LEFT)
                .add(CIRCLE, TOP_CENTER)
                .add(CIRCLE, TOP_RIGHT);

        // when
        Execution result = swapChecker.check(board, CIRCLE, TOP_LEFT, CENTER);

        // then
        Assert.assertTrue(result.isValid());
    }

    @Test
    public void emptyCanBeSwappedToMyPiece() {
        // given
        SwapChecker swapChecker = createSwapChecker();
        Board board = createBoard()
                .add(CIRCLE, TOP_LEFT)
                .add(CIRCLE, TOP_CENTER)
                .add(CIRCLE, TOP_RIGHT);

        // when
        Execution result = swapChecker.check(board, CIRCLE, CENTER, TOP_LEFT);

        // then
        Assert.assertTrue(result.isValid());
    }
}
