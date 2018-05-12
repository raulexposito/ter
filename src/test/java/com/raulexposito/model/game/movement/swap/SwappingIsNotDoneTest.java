package com.raulexposito.model.game.movement.swap;

import com.raulexposito.model.board.Board;
import com.raulexposito.model.board.BoardFixture;
import com.raulexposito.model.game.movement.Movement;
import com.raulexposito.model.game.movement.Swap;
import org.junit.Assert;
import org.junit.Test;

import static com.raulexposito.model.board.Placement.CENTER;
import static com.raulexposito.model.board.Placement.TOP_LEFT;
import static com.raulexposito.model.game.Color.BLACK;

public class SwappingIsNotDoneTest implements BoardFixture {

    @Test
    public void swappingIsNotDone () {
        // given
        Board board = createBoard();
        // when
        Movement movement = new Swap(board, BLACK, CENTER, TOP_LEFT);
        // then
        Assert.assertTrue(movement.isFailure());
    }
}
