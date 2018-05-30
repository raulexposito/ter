package com.raulexposito.ter.model.player;

import com.raulexposito.ter.fixture.player.PlayerFixture;
import com.raulexposito.ter.model.board.Board;
import com.raulexposito.ter.fixture.board.BoardFixture;
import com.raulexposito.ter.fixture.player.fake.FakeOnlyCenterPlayer;
import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;
import static com.raulexposito.ter.model.board.Piece.CIRCLE;
import static com.raulexposito.ter.model.board.Piece.CROSS;
import static com.raulexposito.ter.model.board.Placement.*;

public class BoardStatusTest implements PlayerFixture, BoardFixture {

    @Test
    public void addPieces() {
        // given
        Board board = createBoard()
                .add(CROSS, TOP_LEFT)
                .add(CROSS, TOP_CENTER)
                .add(CIRCLE, CENTER);
        Player player = new FakeOnlyCenterPlayer(CIRCLE);

        // when
        player.move(board);

        // then
        assertThat(player.mySquares().size()).isEqualTo(1);
        assertThat(player.rivalSquares().size()).isEqualTo(2);
        assertThat(player.emptySquares().size()).isEqualTo(6);
    }
}
