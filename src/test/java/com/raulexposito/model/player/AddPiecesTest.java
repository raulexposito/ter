package com.raulexposito.model.player;

import com.raulexposito.model.board.Board;
import com.raulexposito.model.board.BoardFixture;
import com.raulexposito.model.movement.Movement;
import com.raulexposito.model.player.fake.FakeAddPlayer;
import org.junit.Assert;
import org.junit.Test;

import static com.raulexposito.model.board.Placement.*;
import static com.raulexposito.model.Color.*;

public class AddPiecesTest implements PlayerFixture, BoardFixture {

    @Test
    public void addPieces () {
        // given
        Board board = createBoard();
        Player player = new FakeAddPlayer(WHITE, CENTER);
        // when
        Movement movement = player.move(board);
        // then
        Assert.assertEquals(Long.valueOf(1), movement.getBoard().howMany(WHITE));
        Assert.assertTrue(movement.getBoard().hasColor(CENTER, WHITE));
    }
}
