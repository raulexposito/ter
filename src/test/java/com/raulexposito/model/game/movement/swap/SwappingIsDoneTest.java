package com.raulexposito.model.game.movement.swap;

import com.raulexposito.model.board.Board;
import com.raulexposito.model.board.BoardFixture;
import com.raulexposito.model.game.movement.Movement;
import com.raulexposito.model.game.movement.Swap;
import org.junit.Assert;
import org.junit.Test;

import static com.raulexposito.model.board.Placement.*;
import static com.raulexposito.model.game.Color.BLACK;

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
        Assert.assertFalse(movement.isFailure());
        Assert.assertFalse(movement.isVictory());
        Assert.assertTrue(movement.getBoard().hasColor(TOP_LEFT, BLACK));
        Assert.assertTrue(movement.getBoard().isEmpty(CENTER));
    }
}
