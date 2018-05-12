package com.raulexposito.model.game.checker.add;

import com.raulexposito.model.board.Board;
import com.raulexposito.model.Result;
import com.raulexposito.model.board.BoardFixture;
import com.raulexposito.model.game.checker.AddChecker;
import org.junit.Assert;
import org.junit.Test;

import static com.raulexposito.model.board.Placement.*;
import static com.raulexposito.model.game.Color.BLACK;
import static com.raulexposito.model.game.Color.WHITE;

public class FailingAddingTest implements AddCheckerFixture, BoardFixture {

    @Test
    public void colorsCannotBeOverlapped() {
        // given
        AddChecker putChecker = createPutChecker();
        Board board = createBoard()
                .add(BLACK, CENTER);
        // when
        Result result = putChecker.check(board, WHITE, CENTER);
        // then
        Assert.assertEquals(Result.FAILURE, result);
    }

    @Test
    public void fourEqualsColorsCannotBeAdded() {
        // given
        AddChecker putChecker = createPutChecker();
        Board board = createBoard()
                .add(BLACK, TOP_LEFT)
                .add(BLACK, TOP_CENTER)
                .add(BLACK, TOP_RIGHT);
        // when
        Result result = putChecker.check(board, BLACK, CENTER);
        // then
        Assert.assertEquals(Long.valueOf(3), board.howMany(BLACK));
        Assert.assertEquals(Result.FAILURE, result);
    }
}
