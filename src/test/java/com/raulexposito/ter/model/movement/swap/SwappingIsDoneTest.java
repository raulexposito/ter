package com.raulexposito.ter.model.movement.swap;

import com.raulexposito.ter.model.board.Board;
import com.raulexposito.ter.fixture.board.BoardFixture;
import com.raulexposito.ter.model.movement.Movement;
import com.raulexposito.ter.model.movement.Swap;
import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;
import static com.raulexposito.ter.model.board.Piece.CIRCLE;
import static com.raulexposito.ter.model.board.Placement.*;

public class SwappingIsDoneTest implements BoardFixture {

    @Test
    public void swappingIsDone() {
        // given
        Board board = createBoard()
                .add(CIRCLE, MIDDLE_LEFT)
                .add(CIRCLE, CENTER)
                .add(CIRCLE, MIDDLE_RIGHT);

        // when
        Movement movement = new Swap(board, CIRCLE, CENTER, TOP_LEFT);

        // then
        assertThat(movement.isFailed()).isFalse();
        assertThat(movement.isVictory()).isFalse();
        assertThat(movement.getBoard().hasPiece(TOP_LEFT, CIRCLE)).isTrue();
        assertThat(movement.getBoard().isEmpty(CENTER)).isTrue();
    }
}
