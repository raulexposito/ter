package com.raulexposito.model.game.game;

import com.raulexposito.model.board.BoardFixture;
import com.raulexposito.model.game.Game;
import com.raulexposito.model.game.result.Result;
import com.raulexposito.model.player.Player;
import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;
import static com.raulexposito.model.board.Piece.CIRCLE;
import static com.raulexposito.model.board.Piece.CROSS;

public class PlayerLooseAttemptsReachedTest implements BoardFixture {

    @Test
    public void playerLooseAttemptsReached() {
        // given
        Player winner = new TopRowPlayer(CIRCLE);
        Player looser = new OnlyCenterPlayer(CROSS);
        Game game = new Game(looser, winner);

        // when
        Result result = game.play();

        // then
        assertThat(result.isVictory()).isTrue();
        assertThat(result.getWinner().isPresent()).isTrue();
        assertThat(result.getWinner().get()).isEqualTo(CIRCLE);
    }
}
