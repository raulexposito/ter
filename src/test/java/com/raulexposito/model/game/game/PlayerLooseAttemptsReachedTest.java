package com.raulexposito.model.game.game;

import com.raulexposito.model.board.BoardFixture;
import com.raulexposito.model.game.Game;
import com.raulexposito.model.game.result.Result;
import com.raulexposito.model.player.Player;
import org.junit.Assert;
import org.junit.Test;

import static com.raulexposito.model.board.Piece.CIRCLE;
import static com.raulexposito.model.board.Piece.CROSS;

public class PlayerLooseAttemptsReachedTest implements BoardFixture {

    private static final String OUTPUT = "{\"result\": \"VICTORY\",\"winner\": \"CIRCLE\",\"movements\": [{\"TL\":\"\",\"TC\":\"\",\"TR\":\"\",\"ML\":\"\",\"C\":\"X\",\"MR\":\"\",\"BL\":\"\",\"BC\":\"\",\"BR\":\"\"},{\"TL\":\"O\",\"TC\":\"\",\"TR\":\"\",\"ML\":\"\",\"C\":\"X\",\"MR\":\"\",\"BL\":\"\",\"BC\":\"\",\"BR\":\"\"},{\"TL\":\"O\",\"TC\":\"\",\"TR\":\"\",\"ML\":\"\",\"C\":\"X\",\"MR\":\"\",\"BL\":\"\",\"BC\":\"\",\"BR\":\"\"},{\"TL\":\"O\",\"TC\":\"\",\"TR\":\"\",\"ML\":\"\",\"C\":\"X\",\"MR\":\"\",\"BL\":\"\",\"BC\":\"\",\"BR\":\"\"},{\"TL\":\"O\",\"TC\":\"\",\"TR\":\"\",\"ML\":\"\",\"C\":\"X\",\"MR\":\"\",\"BL\":\"\",\"BC\":\"\",\"BR\":\"\"},{\"TL\":\"O\",\"TC\":\"\",\"TR\":\"\",\"ML\":\"\",\"C\":\"X\",\"MR\":\"\",\"BL\":\"\",\"BC\":\"\",\"BR\":\"\"},{\"TL\":\"O\",\"TC\":\"\",\"TR\":\"\",\"ML\":\"\",\"C\":\"X\",\"MR\":\"\",\"BL\":\"\",\"BC\":\"\",\"BR\":\"\"},{\"TL\":\"O\",\"TC\":\"\",\"TR\":\"\",\"ML\":\"\",\"C\":\"X\",\"MR\":\"\",\"BL\":\"\",\"BC\":\"\",\"BR\":\"\"},{\"TL\":\"O\",\"TC\":\"\",\"TR\":\"\",\"ML\":\"\",\"C\":\"X\",\"MR\":\"\",\"BL\":\"\",\"BC\":\"\",\"BR\":\"\"},{\"TL\":\"O\",\"TC\":\"\",\"TR\":\"\",\"ML\":\"\",\"C\":\"X\",\"MR\":\"\",\"BL\":\"\",\"BC\":\"\",\"BR\":\"\"},{\"TL\":\"O\",\"TC\":\"\",\"TR\":\"\",\"ML\":\"\",\"C\":\"X\",\"MR\":\"\",\"BL\":\"\",\"BC\":\"\",\"BR\":\"\"},{\"TL\":\"O\",\"TC\":\"\",\"TR\":\"\",\"ML\":\"\",\"C\":\"X\",\"MR\":\"\",\"BL\":\"\",\"BC\":\"\",\"BR\":\"\"},{\"TL\":\"O\",\"TC\":\"\",\"TR\":\"\",\"ML\":\"\",\"C\":\"X\",\"MR\":\"\",\"BL\":\"\",\"BC\":\"\",\"BR\":\"\"},{\"TL\":\"O\",\"TC\":\"\",\"TR\":\"\",\"ML\":\"\",\"C\":\"X\",\"MR\":\"\",\"BL\":\"\",\"BC\":\"\",\"BR\":\"\"},{\"TL\":\"O\",\"TC\":\"\",\"TR\":\"\",\"ML\":\"\",\"C\":\"X\",\"MR\":\"\",\"BL\":\"\",\"BC\":\"\",\"BR\":\"\"},{\"TL\":\"O\",\"TC\":\"\",\"TR\":\"\",\"ML\":\"\",\"C\":\"X\",\"MR\":\"\",\"BL\":\"\",\"BC\":\"\",\"BR\":\"\"},{\"TL\":\"O\",\"TC\":\"\",\"TR\":\"\",\"ML\":\"\",\"C\":\"X\",\"MR\":\"\",\"BL\":\"\",\"BC\":\"\",\"BR\":\"\"},{\"TL\":\"O\",\"TC\":\"\",\"TR\":\"\",\"ML\":\"\",\"C\":\"X\",\"MR\":\"\",\"BL\":\"\",\"BC\":\"\",\"BR\":\"\"},{\"TL\":\"O\",\"TC\":\"\",\"TR\":\"\",\"ML\":\"\",\"C\":\"X\",\"MR\":\"\",\"BL\":\"\",\"BC\":\"\",\"BR\":\"\"},{\"TL\":\"O\",\"TC\":\"\",\"TR\":\"\",\"ML\":\"\",\"C\":\"X\",\"MR\":\"\",\"BL\":\"\",\"BC\":\"\",\"BR\":\"\"},{\"TL\":\"O\",\"TC\":\"\",\"TR\":\"\",\"ML\":\"\",\"C\":\"X\",\"MR\":\"\",\"BL\":\"\",\"BC\":\"\",\"BR\":\"\"},{\"TL\":\"O\",\"TC\":\"\",\"TR\":\"\",\"ML\":\"\",\"C\":\"X\",\"MR\":\"\",\"BL\":\"\",\"BC\":\"\",\"BR\":\"\"}]}";

    @Test
    public void playerLooseAttemptsReached() {
        // given
        Player winner = new TopRowPlayer(CIRCLE);
        Player looser = new OnlyCenterPlayer(CROSS);
        Game game = new Game(looser, winner);

        // when
        Result result = game.play();

        // then
        Assert.assertTrue(result.isVictory());
        Assert.assertTrue(result.getWinner().isPresent());
        Assert.assertEquals(CIRCLE, result.getWinner().get());
        Assert.assertEquals(OUTPUT, result.toString());
    }
}
