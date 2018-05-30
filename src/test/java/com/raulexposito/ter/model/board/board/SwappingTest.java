package com.raulexposito.ter.model.board.board;

import com.raulexposito.ter.model.board.Board;
import com.raulexposito.ter.fixture.board.BoardFixture;
import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;
import static com.raulexposito.ter.model.board.Piece.CIRCLE;
import static com.raulexposito.ter.model.board.Placement.*;

public class SwappingTest implements BoardFixture {

    @Test
    public void boardCanSwapPieces() {
        // given
        Board board = createBoard()
                .add(CIRCLE, TOP_LEFT)
                .add(CIRCLE, TOP_CENTER)
                .add(CIRCLE, TOP_RIGHT);

        // when
        board = board.swap(TOP_LEFT, CENTER);

        // then
        assertThat(board.isEmpty(TOP_LEFT)).isTrue();
        assertThat(board.isFilled(TOP_CENTER)).isTrue();
        assertThat(board.isFilled(TOP_RIGHT)).isTrue();
        assertThat(board.isFilled(CENTER)).isTrue();
    }
}