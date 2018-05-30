package com.raulexposito.ter.model.movement.swap;

import com.raulexposito.ter.fixture.checker.SwapCheckerFixture;
import com.raulexposito.ter.model.board.Board;
import com.raulexposito.ter.fixture.board.BoardFixture;
import com.raulexposito.ter.model.movement.check.SwapChecker;
import com.raulexposito.ter.model.movement.execution.Execution;
import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;
import static com.raulexposito.ter.model.board.Piece.CIRCLE;
import static com.raulexposito.ter.model.board.Placement.*;

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
        assertThat(result.isValid()).isTrue();
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
        assertThat(result.isValid()).isTrue();
    }
}
