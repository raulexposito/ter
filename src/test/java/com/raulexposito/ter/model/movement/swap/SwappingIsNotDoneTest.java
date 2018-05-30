package com.raulexposito.ter.model.movement.swap;

import com.raulexposito.ter.model.board.Board;
import com.raulexposito.ter.fixture.board.BoardFixture;
import com.raulexposito.ter.model.movement.Movement;
import com.raulexposito.ter.model.movement.Swap;
import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;
import static com.raulexposito.ter.model.board.Piece.CIRCLE;
import static com.raulexposito.ter.model.board.Placement.CENTER;
import static com.raulexposito.ter.model.board.Placement.TOP_LEFT;

public class SwappingIsNotDoneTest implements BoardFixture {

    @Test
    public void swappingIsNotDone() {
        // given
        Board board = createBoard();

        // when
        Movement movement = new Swap(board, CIRCLE, CENTER, TOP_LEFT);

        // then
        assertThat(movement.isFailed()).isTrue();
    }
}
