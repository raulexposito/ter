package com.raulexposito.model.game.checker.victory;

import com.raulexposito.model.board.Board;
import com.raulexposito.model.board.BoardFixture;
import com.raulexposito.model.game.checker.VictoryChecker;
import org.junit.Assert;
import org.junit.Test;

import static com.raulexposito.model.board.Color.BLACK;
import static com.raulexposito.model.board.Placement.*;

public class RowVictoryTest implements VictoryCheckerFixture, BoardFixture {

    @Test
    public void topRowFilled() {
        // given
        VictoryChecker checker = createVictoryChecker();
        Board board = createBoard();
        // when
        board = board
                .add(BLACK, TOP_LEFT)
                .add(BLACK, TOP_CENTER)
                .add(BLACK, TOP_RIGHT);
        // then
        Assert.assertTrue(checker.isVictory(board));
    }

    @Test
    public void middleRowFilled() {
        // given
        VictoryChecker checker = createVictoryChecker();
        Board board = createBoard();
        // when
        board = board
                .add(BLACK, MIDDLE_LEFT)
                .add(BLACK, CENTER)
                .add(BLACK, MIDDLE_RIGHT);
        // then
        Assert.assertTrue(checker.isVictory(board));
    }

    @Test
    public void bottomRowFilled() {
        // given
        VictoryChecker checker = createVictoryChecker();
        Board board = createBoard();
        // when
        board = board
                .add(BLACK, BOTTOM_LEFT)
                .add(BLACK, BOTTOM_CENTER)
                .add(BLACK, BOTTOM_RIGHT);
        // then
        Assert.assertTrue(checker.isVictory(board));
    }
}
