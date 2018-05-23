package com.raulexposito.model.game.result;

import com.raulexposito.helper.JsonReader;
import com.raulexposito.model.game.Game;
import com.raulexposito.model.game.game.BottomRowPlayer;
import com.raulexposito.model.game.game.TopRowPlayer;
import com.raulexposito.model.player.Player;
import org.junit.Assert;
import org.junit.Test;

import static com.raulexposito.model.board.Piece.CIRCLE;
import static com.raulexposito.model.board.Piece.CROSS;

public class ResultRenderingTest implements JsonReader {

    @Test
    public void jsonRepresentsContent() {
        // given
        Player winner = new TopRowPlayer(CROSS);
        Player looser = new BottomRowPlayer(CIRCLE);
        Game game = new Game(winner, looser);

        // when
        String json = game.play().toJSON();

        // then
        Assert.assertTrue(contains(json, "result", "VICTORY"));
        Assert.assertTrue(contains(json, "winner", "CROSS"));
        Assert.assertTrue(contains(json, "cross", "TOPROWPLAYER"));
        Assert.assertTrue(contains(json, "circle", "BOTTOMROWPLAYER"));
        Assert.assertTrue(contains(json, "length", Double.valueOf(5)));
    }
}
