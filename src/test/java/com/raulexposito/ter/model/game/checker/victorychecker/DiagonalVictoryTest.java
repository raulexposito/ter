package com.raulexposito.ter.model.game.checker.victorychecker;

import com.raulexposito.ter.fixture.game.checker.VictoryCheckerFixture;
import com.raulexposito.ter.model.board.Board;
import com.raulexposito.ter.fixture.board.BoardFixture;
import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;
import static com.raulexposito.ter.model.board.Piece.CIRCLE;
import static com.raulexposito.ter.model.board.Placement.*;

public class DiagonalVictoryTest implements VictoryCheckerFixture, BoardFixture {

    @Test
    public void topLeftToBottomRightFilled() {
        // given
        Board board = createBoard();

        // when
        board = board
                .add(CIRCLE, TOP_LEFT)
                .add(CIRCLE, CENTER)
                .add(CIRCLE, BOTTOM_RIGHT);

        // then
        assertThat(createVictoryChecker(board).isVictory()).isTrue();
    }

    @Test
    public void topRightToBottomLeftFilled() {
        // given
        Board board = createBoard();

        // when
        board = board
                .add(CIRCLE, TOP_RIGHT)
                .add(CIRCLE, CENTER)
                .add(CIRCLE, BOTTOM_LEFT);

        // then
        assertThat(createVictoryChecker(board).isVictory()).isTrue();
    }
}
