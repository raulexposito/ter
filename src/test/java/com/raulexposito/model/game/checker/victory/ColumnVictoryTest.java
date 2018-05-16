package com.raulexposito.model.game.checker.victory;

import com.raulexposito.model.board.Board;
import com.raulexposito.model.board.BoardFixture;
import com.raulexposito.model.game.checker.VictoryChecker;
import org.junit.Assert;
import org.junit.Test;

import static com.raulexposito.model.board.Piece.CIRCLE;
import static com.raulexposito.model.board.Piece.CROSS;
import static com.raulexposito.model.board.Placement.*;

public class ColumnVictoryTest implements VictoryCheckerFixture, BoardFixture {

    @Test
    public void leftColumnFilled() {
        // given
        VictoryChecker checker = createVictoryChecker();
        Board board = createBoard();
        // when
        board = board
                .add(CIRCLE, TOP_LEFT)
                .add(CIRCLE, MIDDLE_LEFT)
                .add(CIRCLE, BOTTOM_LEFT);
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
                .add(CROSS, TOP_CENTER)
                .add(CROSS, CENTER)
                .add(CROSS, BOTTOM_CENTER);
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
                .add(CIRCLE, TOP_RIGHT)
                .add(CIRCLE, MIDDLE_RIGHT)
                .add(CIRCLE, BOTTOM_RIGHT);
        // then
        Assert.assertTrue(checker.isVictory(board));
    }
}
