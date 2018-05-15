package com.raulexposito.model.movement.swap;

import com.raulexposito.model.board.Board;
import com.raulexposito.model.board.BoardFixture;
import com.raulexposito.model.movement.Movement;
import com.raulexposito.model.movement.Swap;
import org.junit.Assert;
import org.junit.Test;

import static com.raulexposito.model.board.Color.BLACK;
import static com.raulexposito.model.board.Placement.*;

public class SwappingIsDoneTest implements BoardFixture {

    @Test
    public void swappingIsDone() {
        // given
        Board board = createBoard()
                .add(BLACK, MIDDLE_LEFT)
                .add(BLACK, CENTER)
                .add(BLACK, MIDDLE_RIGHT);
        // when
        Movement movement = new Swap(board, BLACK, CENTER, TOP_LEFT);
        // then
        Assert.assertFalse(movement.isFailed());
        Assert.assertFalse(movement.isVictory());
        Assert.assertTrue(movement.getBoard().hasColor(TOP_LEFT, BLACK));
        Assert.assertTrue(movement.getBoard().isEmpty(CENTER));
    }
}
