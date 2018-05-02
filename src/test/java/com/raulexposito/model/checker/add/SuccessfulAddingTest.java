package com.raulexposito.model.checker.add;

import com.raulexposito.model.Board;
import com.raulexposito.model.Result;
import com.raulexposito.model.board.BoardFixture;
import com.raulexposito.model.checker.AddChecker;
import org.junit.Assert;
import org.junit.Test;

import static com.raulexposito.model.Placement.CENTER;
import static com.raulexposito.model.Color.BLACK;

public class SuccessfulAddingTest implements AddCheckerFixture, BoardFixture {

    @Test
    public void colorsCanBeAdded() {
        // given
        Board board = createBoard();
        AddChecker putChecker = createPutChecker();
        // when
        Result result = putChecker.check(board, BLACK, CENTER);
        // then
        Assert.assertEquals(Result.CONTINUE, result);
    }
}
