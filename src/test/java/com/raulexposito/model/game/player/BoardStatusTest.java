package com.raulexposito.model.game.player;

import com.raulexposito.model.board.Board;
import com.raulexposito.model.board.BoardFixture;
import com.raulexposito.model.game.Player;
import com.raulexposito.model.game.player.fake.DoNothingPlayer;
import org.junit.Assert;
import org.junit.Test;

import static com.raulexposito.model.board.Placement.*;
import static com.raulexposito.model.game.Color.*;

public class BoardStatusTest implements PlayerFixture, BoardFixture {

    @Test
    public void addPieces () {
        // given
        Board board = createBoard()
                .add(WHITE, TOP_LEFT)
                .add(WHITE, TOP_CENTER)
                .add(BLACK, CENTER);
        Player player = new DoNothingPlayer(BLACK);
        // when
        player.move(board);
        // then
        Assert.assertEquals(1L, player.mySquares().size());
        Assert.assertEquals(2L, player.rivalSquares().size());
        Assert.assertEquals(6L, player.emptySquares().size());
    }
}
