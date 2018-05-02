package com.raulexposito.model.checker.add;

import com.raulexposito.model.Board;
import com.raulexposito.model.MovementResult;
import com.raulexposito.model.board.BoardFixture;
import com.raulexposito.model.checker.AddChecker;
import org.junit.Assert;
import org.junit.Test;

import static com.raulexposito.model.Placement.CENTER;
import static com.raulexposito.model.cell.Chip.BLACK;

public class SuccessfulAddingTest implements AddCheckerFixture, BoardFixture {

    @Test
    public void chipsCanBeAdded() {
        // given
        Board board = createBoard();
        AddChecker putChecker = createPutChecker();
        // when
        MovementResult result = putChecker.check(board, BLACK, CENTER);
        // then
        Assert.assertEquals(MovementResult.SUCCESS, result);
    }
}
