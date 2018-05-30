package com.raulexposito.ter.model.game.game;

import com.raulexposito.ter.fixture.board.BoardFixture;
import com.raulexposito.ter.model.game.Game;
import com.raulexposito.ter.model.game.result.Result;
import com.raulexposito.ter.model.player.Player;
import com.raulexposito.ter.fixture.player.fake.FakeOnlyCenterPlayer;
import com.raulexposito.ter.fixture.player.fake.FakeTopRowPlayer;
import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;
import static com.raulexposito.ter.model.board.Piece.CIRCLE;
import static com.raulexposito.ter.model.board.Piece.CROSS;

public class PlayerLooseAttemptsReachedTest implements BoardFixture {

    @Test
    public void playerLooseAttemptsReached() {
        // given
        Player winner = new FakeTopRowPlayer(CIRCLE);
        Player looser = new FakeOnlyCenterPlayer(CROSS);
        Game game = new Game(looser, winner);

        // when
        Result result = game.play();

        // then
        assertThat(result.isVictory()).isTrue();
        assertThat(result.getWinner().isPresent()).isTrue();
        assertThat(result.getWinner().get()).isEqualTo(CIRCLE);
    }
}
