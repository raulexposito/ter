package com.raulexposito.model.player;

import com.raulexposito.model.board.Board;
import com.raulexposito.model.board.BoardFixture;
import com.raulexposito.model.movement.Movement;
import com.raulexposito.model.player.fake.FakeSwapPlayer;
import org.junit.Assert;
import org.junit.Test;

import static com.raulexposito.model.board.Piece.CROSS;
import static com.raulexposito.model.board.Placement.CENTER;
import static com.raulexposito.model.board.Placement.TOP_LEFT;

public class SwapPiecesTest implements PlayerFixture, BoardFixture {

    @Test
    public void swapPieces() {
        // given
        Board board = createBoard().add(CROSS, CENTER);
        Player player = new FakeSwapPlayer(CROSS, CENTER, TOP_LEFT);

        // when
        Movement movement = player.move(board);

        // then
        Assert.assertEquals(Long.valueOf(1), movement.getBoard().howMany(CROSS));
        Assert.assertTrue(movement.getBoard().hasPiece(TOP_LEFT, CROSS));
        Assert.assertTrue(movement.getBoard().isEmpty(CENTER));
    }
}
