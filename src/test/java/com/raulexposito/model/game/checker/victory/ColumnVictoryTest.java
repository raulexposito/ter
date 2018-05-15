package com.raulexposito.model.game.checker.victory;

import com.raulexposito.model.board.Board;
import com.raulexposito.model.board.BoardFixture;
import com.raulexposito.model.game.checker.VictoryChecker;
import org.junit.Assert;
import org.junit.Test;

import static com.raulexposito.model.board.Placement.*;
import static com.raulexposito.model.board.Color.*;

public class ColumnVictoryTest implements VictoryCheckerFixture, BoardFixture {

    @Test
    public void leftColumnFilled() {
        // given
        VictoryChecker checker = createVictoryChecker();
        Board board = createBoard();
        // when
        board = board
                .add(BLACK, TOP_LEFT)
                .add(BLACK, MIDDLE_LEFT)
                .add(BLACK, BOTTOM_LEFT);
        // then
        Assert.assertTrue(checker.isVictory(board));
    }

    @Test
    public void middleColumnFilled() {
        // given
        VictoryChecker checker = createVictoryChecker();
        Board board = createBoard();
        // when
        board = board
                .add(WHITE, TOP_CENTER)
                .add(WHITE, CENTER)
                .add(WHITE, BOTTOM_CENTER);
        // then
        Assert.assertTrue(checker.isVictory(board));
    }

    @Test
    public void rightColumnFilled() {
        // given
        VictoryChecker checker = createVictoryChecker();
        Board board = createBoard();
        // when
        board = board
                .add(BLACK, TOP_RIGHT)
                .add(BLACK, MIDDLE_RIGHT)
                .add(BLACK, BOTTOM_RIGHT);
        // then
        Assert.assertTrue(checker.isVictory(board));
    }
}
