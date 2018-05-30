package com.raulexposito.ter.model.board.board;

import com.raulexposito.ter.model.board.Board;
import com.raulexposito.ter.fixture.board.BoardFixture;
import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;
import static com.raulexposito.ter.model.board.Piece.CIRCLE;
import static com.raulexposito.ter.model.board.Piece.CROSS;
import static com.raulexposito.ter.model.board.Placement.CENTER;

public class EmptinessTest implements BoardFixture {

    @Test
    public void boardIsCreatedEmpty() {
        // when
        Board board = createBoard();

        // then
        assertThat(board.howMany(CIRCLE)).isEqualTo(0);
        assertThat(board.howMany(CROSS)).isEqualTo(0);
    }

    @Test
    public void boardIsNotEmptyAfterAdding() {
        // given
        Board board = createBoard();

        // when
        board = board.add(CIRCLE, CENTER);

        // then
        assertThat(board.howMany(CIRCLE)).isEqualTo(1);
        assertThat(board.howMany(CROSS)).isEqualTo(0);
    }
}
