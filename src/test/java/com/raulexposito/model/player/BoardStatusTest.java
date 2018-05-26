package com.raulexposito.model.player;

import com.raulexposito.model.board.Board;
import com.raulexposito.model.board.BoardFixture;
import com.raulexposito.model.player.fake.DoNothingPlayer;
import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;
import static com.raulexposito.model.board.Piece.CIRCLE;
import static com.raulexposito.model.board.Piece.CROSS;
import static com.raulexposito.model.board.Placement.*;

public class BoardStatusTest implements PlayerFixture, BoardFixture {

    @Test
    public void addPieces() {
        // given
        Board board = createBoard()
                .add(CROSS, TOP_LEFT)
                .add(CROSS, TOP_CENTER)
                .add(CIRCLE, CENTER);
        Player player = new DoNothingPlayer(CIRCLE);

        // when
        player.move(board);

        // then
        assertThat(player.mySquares().size()).isEqualTo(1);
        assertThat(player.rivalSquares().size()).isEqualTo(2);
        assertThat(player.emptySquares().size()).isEqualTo(6);
    }
}
