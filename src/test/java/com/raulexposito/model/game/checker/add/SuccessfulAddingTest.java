package com.raulexposito.model.game.checker.add;

import com.raulexposito.model.board.Board;
import com.raulexposito.model.Result;
import com.raulexposito.model.board.BoardFixture;
import com.raulexposito.model.game.checker.AddChecker;
import org.junit.Assert;
import org.junit.Test;

import static com.raulexposito.model.board.Placement.CENTER;
import static com.raulexposito.model.Color.BLACK;

public class SuccessfulAddingTest implements AddCheckerFixture, BoardFixture {

    @Test
    public void squaresCanBeAdded() {
        // given
        AddChecker putChecker = createPutChecker();
        Board board = createBoard();
        // when
        Result result = putChecker.check(board, BLACK, CENTER);
        // then
        Assert.assertEquals(Result.VALID, result);
    }
}
