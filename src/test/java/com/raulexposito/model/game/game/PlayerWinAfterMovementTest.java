package com.raulexposito.model.game.game;

import com.raulexposito.model.board.BoardFixture;
import com.raulexposito.model.game.Game;
import com.raulexposito.model.game.result.Result;
import com.raulexposito.model.player.Player;
import org.junit.Assert;
import org.junit.Test;

import static com.raulexposito.model.board.Color.*;

public class PlayerWinAfterMovementTest implements BoardFixture {

    @Test
    public void playerWinAfterMovement() {
        // given
        Player winner = new TopRowPlayer(WHITE);
        Player looser = new BottomRowPlayer(BLACK);
        Game game = new Game(winner, looser);

        // when
        Result result = game.play();

        // then
        Assert.assertTrue(result.isVictory());
        Assert.assertTrue(result.getWinner().isPresent());
        Assert.assertEquals(WHITE, result.getWinner().get());
    }
}
