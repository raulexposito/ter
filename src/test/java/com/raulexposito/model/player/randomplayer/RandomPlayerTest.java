package com.raulexposito.model.player.randomplayer;

import com.raulexposito.model.board.Board;
import com.raulexposito.model.board.BoardFixture;
import com.raulexposito.model.board.Piece;
import com.raulexposito.model.player.Player;
import com.raulexposito.model.player.PlayerFixture;
import com.raulexposito.model.player.RandomPlayer;
import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

public class RandomPlayerTest implements PlayerFixture, BoardFixture {

    @Test
    public void addsThreeTimes() {
        // given
        Board board = createBoard();
        Player randomPlayer = new RandomPlayer(Piece.CROSS);

        // when
        board = move(board, randomPlayer, MAX_SAME_PIECES);

        // then
        assertThat(board.howMany(Piece.CROSS)).isEqualTo(MAX_SAME_PIECES);
    }

    @Test
    public void swapsTheRestOfTimes() {
        // given
        Board board = createBoard();
        Player randomPlayer = new RandomPlayer(Piece.CROSS);

        // when
        board = move(board, randomPlayer, 500L);

        // then
        assertThat(board.howMany(Piece.CROSS)).isEqualTo(MAX_SAME_PIECES);
    }
}
