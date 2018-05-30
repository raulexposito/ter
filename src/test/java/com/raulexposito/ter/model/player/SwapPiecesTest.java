package com.raulexposito.ter.model.player;

import com.raulexposito.ter.fixture.player.PlayerFixture;
import com.raulexposito.ter.model.board.Board;
import com.raulexposito.ter.fixture.board.BoardFixture;
import com.raulexposito.ter.model.movement.Movement;
import com.raulexposito.ter.fixture.player.fake.FakeSwapPlayer;
import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;
import static com.raulexposito.ter.model.board.Piece.CROSS;
import static com.raulexposito.ter.model.board.Placement.CENTER;
import static com.raulexposito.ter.model.board.Placement.TOP_LEFT;

public class SwapPiecesTest implements PlayerFixture, BoardFixture {

    @Test
    public void swapPieces() {
        // given
        Board board = createBoard().add(CROSS, CENTER);
        Player player = new FakeSwapPlayer(CROSS, CENTER, TOP_LEFT);

        // when
        Movement movement = player.move(board);

        // then
        assertThat(movement.getBoard().howMany(CROSS)).isEqualTo(1);
        assertThat(movement.getBoard().hasPiece(TOP_LEFT, CROSS)).isTrue();
        assertThat(movement.getBoard().isEmpty(CENTER)).isTrue();
    }
}
