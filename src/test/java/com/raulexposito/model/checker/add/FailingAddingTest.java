package com.raulexposito.model.checker.add;

import com.raulexposito.model.Board;
import com.raulexposito.model.MovementResult;
import com.raulexposito.model.board.BoardFixture;
import com.raulexposito.model.checker.AddChecker;
import org.junit.Assert;
import org.junit.Test;

import static com.raulexposito.model.Placement.*;
import static com.raulexposito.model.cell.Chip.BLACK;
import static com.raulexposito.model.cell.Chip.WHITE;

public class FailingAddingTest implements AddCheckerFixture, BoardFixture {

    @Test
    public void chipsCannotBeOverlapped() {
        // given
        Board board = createBoard();
        AddChecker putChecker = createPutChecker();
        board.add(BLACK, CENTER);
        // when
        MovementResult result = putChecker.check(board, WHITE, CENTER);
        // then
        Assert.assertEquals(MovementResult.FAILURE, result);
    }

    @Test
    public void fourEqualsChipsCannotBeAdded() {
        // given
        Board board = createBoard();
        AddChecker putChecker = createPutChecker();
        board.add(BLACK, TOP_LEFT);
        board.add(BLACK, TOP_CENTER);
        board.add(BLACK, TOP_RIGHT);
        // when
        MovementResult result = putChecker.check(board, BLACK, TOP_LEFT);
        // then
        Assert.assertEquals(Integer.valueOf(3), board.count(BLACK));
        Assert.assertEquals(MovementResult.FAILURE, result);
    }
}
