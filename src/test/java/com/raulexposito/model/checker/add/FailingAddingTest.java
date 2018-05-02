package com.raulexposito.model.checker.add;

import com.raulexposito.model.Board;
import com.raulexposito.model.Result;
import com.raulexposito.model.board.BoardFixture;
import com.raulexposito.model.checker.AddChecker;
import org.junit.Assert;
import org.junit.Test;

import static com.raulexposito.model.Placement.*;
import static com.raulexposito.model.Color.BLACK;
import static com.raulexposito.model.Color.WHITE;

public class FailingAddingTest implements AddCheckerFixture, BoardFixture {

    @Test
    public void colorsCannotBeOverlapped() {
        // given
        Board board = createBoard();
        AddChecker putChecker = createPutChecker();
        board.add(BLACK, CENTER);
        // when
        Result result = putChecker.check(board, WHITE, CENTER);
        // then
        Assert.assertEquals(Result.FAILURE, result);
    }

    @Test
    public void fourEqualsColorsCannotBeAdded() {
        // given
        Board board = createBoard();
        AddChecker putChecker = createPutChecker();
        board.add(BLACK, TOP_LEFT);
        board.add(BLACK, TOP_CENTER);
        board.add(BLACK, TOP_RIGHT);
        // when
        Result result = putChecker.check(board, BLACK, TOP_LEFT);
        // then
        Assert.assertEquals(Integer.valueOf(3), board.count(BLACK));
        Assert.assertEquals(Result.FAILURE, result);
    }
}
