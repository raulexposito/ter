package com.raulexposito.model.movement.swap;

import com.raulexposito.model.board.Board;
import com.raulexposito.model.board.BoardFixture;
import com.raulexposito.model.movement.Movement;
import com.raulexposito.model.movement.Swap;
import org.junit.Assert;
import org.junit.Test;

import static com.raulexposito.model.board.Placement.CENTER;
import static com.raulexposito.model.board.Placement.TOP_LEFT;
import static com.raulexposito.model.Color.BLACK;

public class SwappingIsNotDoneTest implements BoardFixture {

    @Test
    public void swappingIsNotDone () {
        // given
        Board board = createBoard();
        // when
        Movement movement = new Swap(board, BLACK, CENTER, TOP_LEFT);
        // then
        Assert.assertTrue(movement.isFailed());
    }
}
