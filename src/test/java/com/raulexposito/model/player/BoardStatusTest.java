package com.raulexposito.model.player;

import com.raulexposito.model.board.Board;
import com.raulexposito.model.board.BoardFixture;
import com.raulexposito.model.player.fake.DoNothingPlayer;
import org.junit.Assert;
import org.junit.Test;

import static com.raulexposito.model.board.Piece.CIRCLE;
import static com.raulexposito.model.board.Piece.CROSS;
import static com.raulexposito.model.board.Placement.*;

public class BoardStatusTest implements PlayerFixture, BoardFixture {

    @Test
    public void addPieces () {
        // given
        Board board = createBoard()
                .add(CROSS, TOP_LEFT)
                .add(CROSS, TOP_CENTER)
                .add(CIRCLE, CENTER);
        Player player = new DoNothingPlayer(CIRCLE);
        // when
        player.move(board);
        // then
        Assert.assertEquals(1L, player.mySquares().size());
        Assert.assertEquals(2L, player.rivalSquares().size());
        Assert.assertEquals(6L, player.emptySquares().size());
    }
}
