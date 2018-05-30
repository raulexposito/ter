package com.raulexposito.ter.model.game.checker.victorychecker;

import com.raulexposito.ter.fixture.game.checker.VictoryCheckerFixture;
import com.raulexposito.ter.model.board.Board;
import com.raulexposito.ter.fixture.board.BoardFixture;
import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;
import static com.raulexposito.ter.model.board.Piece.CIRCLE;
import static com.raulexposito.ter.model.board.Piece.CROSS;
import static com.raulexposito.ter.model.board.Placement.*;

public class NoVictoryTest implements VictoryCheckerFixture, BoardFixture {

    @Test
    public void onlyOnePiece() {
        // given
        Board board = createBoard();

        // when
        board = board.add(CIRCLE, CENTER);

        // then
        assertThat(createVictoryChecker(board).isVictory()).isFalse();
    }

    @Test
    public void notEnoughPieces() {
        // given
        Board board = createBoard();

        // when
        board = board
                .add(CIRCLE, TOP_RIGHT)
                .add(CIRCLE, CENTER)
                .add(CROSS, BOTTOM_LEFT);

        // then
        assertThat(createVictoryChecker(board).isVictory()).isFalse();
    }

    @Test
    public void notTheSameRow() {
        // given
        Board board = createBoard();

        // when
        board = board
                .add(CIRCLE, TOP_RIGHT)
                .add(CIRCLE, TOP_CENTER)
                .add(CIRCLE, BOTTOM_LEFT);

        // then
        assertThat(createVictoryChecker(board).isVictory()).isFalse();
    }

    @Test
    public void notTheSameColumn() {
        // given
        Board board = createBoard();

        // when
        board = board
                .add(CIRCLE, TOP_LEFT)
                .add(CIRCLE, MIDDLE_LEFT)
                .add(CIRCLE, BOTTOM_RIGHT);

        // then
        assertThat(createVictoryChecker(board).isVictory()).isFalse();
    }
}
