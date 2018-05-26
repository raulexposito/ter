package com.raulexposito.model.movement.swap;

import com.raulexposito.model.board.Board;
import com.raulexposito.model.board.BoardFixture;
import com.raulexposito.model.movement.Movement;
import com.raulexposito.model.movement.Swap;
import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;
import static com.raulexposito.model.board.Piece.CIRCLE;
import static com.raulexposito.model.board.Placement.CENTER;
import static com.raulexposito.model.board.Placement.TOP_LEFT;

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
