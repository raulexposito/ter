package com.raulexposito.ter.model.movement.swap;

import com.raulexposito.ter.fixture.checker.SwapCheckerFixture;
import com.raulexposito.ter.model.board.Board;
import com.raulexposito.ter.fixture.board.BoardFixture;
import com.raulexposito.ter.model.movement.check.SwapChecker;
import com.raulexposito.ter.model.movement.execution.Execution;
import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;
import static com.raulexposito.ter.model.board.Piece.CIRCLE;
import static com.raulexposito.ter.model.board.Piece.CROSS;
import static com.raulexposito.ter.model.board.Placement.*;

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
        assertThat(board.howMany(CIRCLE)).isEqualTo(2);
        assertThat(result.isFailed()).isTrue();
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
        assertThat(result.isFailed()).isTrue();
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
        assertThat(result.isFailed()).isTrue();
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
        assertThat(result.isFailed()).isTrue();
    }
}
