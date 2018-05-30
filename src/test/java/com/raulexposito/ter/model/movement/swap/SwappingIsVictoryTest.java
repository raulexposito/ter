package com.raulexposito.ter.model.movement.swap;

import com.raulexposito.ter.model.board.Board;
import com.raulexposito.ter.fixture.board.BoardFixture;
import com.raulexposito.ter.model.movement.Movement;
import com.raulexposito.ter.model.movement.Swap;
import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;
import static com.raulexposito.ter.model.board.Piece.CIRCLE;
import static com.raulexposito.ter.model.board.Placement.*;

public class SwappingIsVictoryTest implements BoardFixture {

    @Test
    public void swappingIsVictory() {
        // given
        Board board = createBoard()
                .add(CIRCLE, TOP_LEFT)
                .add(CIRCLE, TOP_CENTER)
                .add(CIRCLE, CENTER);

        // when
        Movement movement = new Swap(board, CIRCLE, CENTER, TOP_RIGHT);

        // then
        assertThat(movement.isVictory()).isTrue();
    }
}