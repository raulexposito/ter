package com.raulexposito.model.player;

import com.raulexposito.model.board.Board;
import com.raulexposito.model.board.BoardFixture;
import com.raulexposito.model.board.Piece;
import com.raulexposito.model.movement.Movement;
import com.raulexposito.model.player.fake.FakeAddPlayer;
import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;
import static com.raulexposito.model.board.Piece.CROSS;
import static com.raulexposito.model.board.Placement.CENTER;

public class AddPiecesTest implements PlayerFixture, BoardFixture {

    @Test
    public void addPieces() {
        // given
        Board board = createBoard();
        Player player = new FakeAddPlayer(CROSS, CENTER);

        // when
        Movement movement = player.move(board);

        // then
        assertThat(movement.getBoard().howMany(Piece.CROSS)).isEqualTo(1);
        assertThat(movement.getBoard().hasPiece(CENTER, CROSS)).isTrue();
    }
}
