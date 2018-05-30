package com.raulexposito.ter.model.player;

import com.raulexposito.ter.fixture.player.PlayerFixture;
import com.raulexposito.ter.model.board.Board;
import com.raulexposito.ter.fixture.board.BoardFixture;
import com.raulexposito.ter.model.board.Piece;
import com.raulexposito.ter.model.movement.Movement;
import com.raulexposito.ter.fixture.player.fake.FakeAddPlayer;
import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;
import static com.raulexposito.ter.model.board.Piece.CROSS;
import static com.raulexposito.ter.model.board.Placement.CENTER;

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
