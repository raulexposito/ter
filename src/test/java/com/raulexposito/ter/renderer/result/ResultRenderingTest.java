package com.raulexposito.ter.renderer.result;

import com.raulexposito.ter.model.game.Game;
import com.raulexposito.ter.fixture.player.fake.FakeBottomRowPlayer;
import com.raulexposito.ter.fixture.player.fake.FakeTopRowPlayer;
import com.raulexposito.ter.model.player.Player;
import com.raulexposito.ter.renderer.JsonNumericReader;
import com.raulexposito.ter.renderer.JsonStringReader;
import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;
import static com.raulexposito.ter.model.board.Piece.CIRCLE;
import static com.raulexposito.ter.model.board.Piece.CROSS;

public class ResultRenderingTest implements JsonStringReader, JsonNumericReader {

    @Test
    public void jsonRepresentsContent() {
        // given
        Player winner = new FakeTopRowPlayer(CROSS);
        Player looser = new FakeBottomRowPlayer(CIRCLE);
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
