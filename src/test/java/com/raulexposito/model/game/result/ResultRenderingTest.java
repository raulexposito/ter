package com.raulexposito.model.game.result;

import com.raulexposito.helper.JsonReader;
import com.raulexposito.model.game.Game;
import com.raulexposito.model.game.game.BottomRowPlayer;
import com.raulexposito.model.game.game.TopRowPlayer;
import com.raulexposito.model.player.Player;
import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;
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
        assertThat(theValue("result").of(json)).isEqualTo("VICTORY");
        assertThat(theValue("winner").of(json)).isEqualTo("CROSS");
        assertThat(theValue("cross").of(json)).isEqualTo("TOPROWPLAYER");
        assertThat(theValue("circle").of(json)).isEqualTo("BOTTOMROWPLAYER");
        assertThat(theNumericValue("length").of(json)).isEqualTo(5);
    }
}
