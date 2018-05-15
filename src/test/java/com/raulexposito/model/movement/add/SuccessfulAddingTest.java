package com.raulexposito.model.movement.add;

import com.raulexposito.model.board.Board;
import com.raulexposito.model.board.BoardFixture;
import com.raulexposito.model.movement.check.AddChecker;
import com.raulexposito.model.movement.execution.Execution;
import org.junit.Assert;
import org.junit.Test;

import static com.raulexposito.model.board.Placement.CENTER;
import static com.raulexposito.model.board.Color.BLACK;

public class SuccessfulAddingTest implements AddCheckerFixture, BoardFixture {

    @Test
    public void piecesCanBeAdded() {
        // given
        AddChecker addChecker = createAddChecker();
        Board board = createBoard();
        // when
        Execution result = addChecker.check(board, BLACK, CENTER);
        // then
        Assert.assertTrue(result.isValid());
    }
}
