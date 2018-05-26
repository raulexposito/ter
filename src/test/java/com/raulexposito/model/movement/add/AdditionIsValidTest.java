package com.raulexposito.model.movement.add;

import com.raulexposito.model.board.Board;
import com.raulexposito.model.board.BoardFixture;
import com.raulexposito.model.movement.Add;
import com.raulexposito.model.movement.Movement;
import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;
import static com.raulexposito.model.board.Piece.CIRCLE;
import static com.raulexposito.model.board.Placement.CENTER;

public class AdditionIsValidTest implements BoardFixture {

    @Test
    public void additionIsDone() {
        // given
        Board board = createBoard();

        // when
        Movement movement = new Add(board, CIRCLE, CENTER);

        // then
        assertThat(movement.isFailed()).isFalse();
        assertThat(movement.isVictory()).isFalse();
        assertThat(movement.getBoard().hasPiece(CENTER, CIRCLE)).isTrue();
    }
}
