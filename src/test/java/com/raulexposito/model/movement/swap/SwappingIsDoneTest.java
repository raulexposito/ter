package com.raulexposito.model.movement.swap;

import com.raulexposito.model.board.Board;
import com.raulexposito.model.board.BoardFixture;
import com.raulexposito.model.movement.Movement;
import com.raulexposito.model.movement.Swap;
import org.junit.Assert;
import org.junit.Test;

import static com.raulexposito.model.board.Piece.CIRCLE;
import static com.raulexposito.model.board.Placement.*;

public class SwappingIsDoneTest implements BoardFixture {

    @Test
    public void swappingIsDone() {
        // given
        Board board = createBoard()
                .add(CIRCLE, MIDDLE_LEFT)
                .add(CIRCLE, CENTER)
                .add(CIRCLE, MIDDLE_RIGHT);
        // when
        Movement movement = new Swap(board, CIRCLE, CENTER, TOP_LEFT);
        // then
        Assert.assertFalse(movement.isFailed());
        Assert.assertFalse(movement.isVictory());
        Assert.assertTrue(movement.getBoard().hasPiece(TOP_LEFT, CIRCLE));
        Assert.assertTrue(movement.getBoard().isEmpty(CENTER));
    }
}
