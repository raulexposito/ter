package com.raulexposito.model.board;

import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;
import static com.raulexposito.model.board.Piece.CIRCLE;
import static com.raulexposito.model.board.Piece.CROSS;

public class PieceTest {

    @Test
    public void circlesOppositeIsCross() {
        // given
        Piece piece = CIRCLE;

        // when
        Piece opposite = piece.getOpposite();

        // then
        assertThat(opposite).isEqualTo(CROSS);
    }

    @Test
    public void crossOppositeIsCircle() {
        // given
        Piece piece = CROSS;

        // when
        Piece opposite = piece.getOpposite();

        // then
        assertThat(opposite).isEqualTo(CIRCLE);
    }
}
