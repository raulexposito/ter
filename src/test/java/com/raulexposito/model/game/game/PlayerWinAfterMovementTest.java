package com.raulexposito.model.game.game;

import com.raulexposito.model.board.BoardFixture;
import com.raulexposito.model.game.Game;
import com.raulexposito.model.game.result.Result;
import com.raulexposito.model.player.Player;
import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;
import static com.raulexposito.model.board.Piece.CIRCLE;
import static com.raulexposito.model.board.Piece.CROSS;

public class PlayerWinAfterMovementTest implements BoardFixture {

    @Test
    public void playerWinAfterMovement() {
        // given
        Player winner = new TopRowPlayer(CROSS);
        Player looser = new BottomRowPlayer(CIRCLE);
        Game game = new Game(winner, looser);

        // when
        Result result = game.play();

        // then
        assertThat(result.isVictory()).isTrue();
        assertThat(result.getWinner().isPresent()).isTrue();
        assertThat(result.getWinner().get()).isEqualTo(CROSS);
    }
}
