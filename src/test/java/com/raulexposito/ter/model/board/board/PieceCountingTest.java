package com.raulexposito.ter.model.board.board;

import com.raulexposito.ter.model.board.Board;
import com.raulexposito.ter.fixture.board.BoardFixture;
import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;
import static com.raulexposito.ter.model.board.Piece.CIRCLE;
import static com.raulexposito.ter.model.board.Piece.CROSS;
import static com.raulexposito.ter.model.board.Placement.*;

public class PieceCountingTest implements BoardFixture {

    @Test
    public void countOnePieceType() {
        // given
        Board board = createBoard();

        // when
        board = board
                .add(CIRCLE, TOP_CENTER)
                .add(CIRCLE, CENTER)
                .add(CIRCLE, BOTTOM_CENTER);

        // then
        assertThat(board.howMany(CIRCLE)).isEqualTo(3);
    }

    @Test
    public void countTwoPiecesType() {
        // given
        Board board = createBoard();

        // when
        board = board
                .add(CIRCLE, TOP_LEFT)
                .add(CROSS, TOP_CENTER)
                .add(CROSS, MIDDLE_LEFT)
                .add(CROSS, CENTER);

        // then
        assertThat(board.howMany(CIRCLE)).isEqualTo(1);
        assertThat(board.howMany(CROSS)).isEqualTo(3);
    }
}
