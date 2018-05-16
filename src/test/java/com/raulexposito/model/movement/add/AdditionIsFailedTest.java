package com.raulexposito.model.movement.add;

import com.raulexposito.model.board.Board;
import com.raulexposito.model.board.BoardFixture;
import com.raulexposito.model.movement.Add;
import com.raulexposito.model.movement.Movement;
import org.junit.Assert;
import org.junit.Test;

import static com.raulexposito.model.board.Piece.CIRCLE;
import static com.raulexposito.model.board.Placement.CENTER;

public class AdditionIsFailedTest implements BoardFixture {

    @Test
    public void additionIsNotDone () {
        // given
        Board board = createBoard().add(CIRCLE, CENTER);
        // when
        Movement movement = new Add(board, CIRCLE, CENTER);
        // then
        Assert.assertTrue(movement.isFailed());
    }
}
