package com.raulexposito.ter.model.movement.add;

import com.raulexposito.ter.model.board.Board;
import com.raulexposito.ter.fixture.board.BoardFixture;
import com.raulexposito.ter.model.movement.Add;
import com.raulexposito.ter.model.movement.Movement;
import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;
import static com.raulexposito.ter.model.board.Piece.CIRCLE;
import static com.raulexposito.ter.model.board.Placement.*;

public class AdditionIsVictoryTest implements BoardFixture {

    @Test
    public void additionIsDone() {
        // given
        Board board = createBoard()
                .add(CIRCLE, TOP_LEFT)
                .add(CIRCLE, TOP_CENTER);

        // when
        Movement movement = new Add(board, CIRCLE, TOP_RIGHT);

        // then
        assertThat(movement.isVictory()).isTrue();
    }
}