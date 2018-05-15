package com.raulexposito.model.movement.add;

import com.raulexposito.model.board.Board;
import com.raulexposito.model.board.BoardFixture;
import com.raulexposito.model.movement.check.AddChecker;
import com.raulexposito.model.movement.execution.Execution;
import org.junit.Assert;
import org.junit.Test;

import static com.raulexposito.model.board.Placement.*;
import static com.raulexposito.model.board.Color.BLACK;
import static com.raulexposito.model.board.Color.WHITE;

public class FailingAddingTest implements AddCheckerFixture, BoardFixture {

    @Test
    public void colorsCannotBeOverlapped() {
        // given
        AddChecker addChecker = createAddChecker();
        Board board = createBoard()
                .add(BLACK, CENTER);
        // when
        Execution result = addChecker.check(board, WHITE, CENTER);
        // then
        Assert.assertTrue(result.isFailed());
    }

    @Test
    public void fourEqualsColorsCannotBeAdded() {
        // given
        AddChecker addChecker = createAddChecker();
        Board board = createBoard()
                .add(BLACK, TOP_LEFT)
                .add(BLACK, TOP_CENTER)
                .add(BLACK, TOP_RIGHT);
        // when
        Execution result = addChecker.check(board, BLACK, CENTER);
        // then
        Assert.assertEquals(Long.valueOf(3), board.howMany(BLACK));
        Assert.assertTrue(result.isFailed());
    }
}
