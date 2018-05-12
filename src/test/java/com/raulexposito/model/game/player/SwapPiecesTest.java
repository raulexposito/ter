package com.raulexposito.model.game.player;

import com.raulexposito.model.board.Board;
import com.raulexposito.model.board.BoardFixture;
import com.raulexposito.model.game.Player;
import com.raulexposito.model.game.movement.Movement;
import com.raulexposito.model.game.player.fake.FakeSwapPlayer;
import org.junit.Assert;
import org.junit.Test;

import static com.raulexposito.model.board.Placement.CENTER;
import static com.raulexposito.model.board.Placement.TOP_LEFT;
import static com.raulexposito.model.game.Color.WHITE;

public class SwapPiecesTest implements PlayerFixture, BoardFixture {

    @Test
    public void swapPieces () {
        // given
        Board board = createBoard().add(WHITE, CENTER);
        Player player = new FakeSwapPlayer(WHITE, CENTER, TOP_LEFT);
        // when
        Movement movement = player.move(board);
        // then
        Assert.assertEquals(Long.valueOf(1), movement.getBoard().howMany(WHITE));
        Assert.assertTrue(movement.getBoard().hasColor(TOP_LEFT, WHITE));
        Assert.assertTrue(movement.getBoard().isEmpty(CENTER));
    }
}
