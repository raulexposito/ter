package com.raulexposito.model.checker.victory;

import com.raulexposito.model.Board;
import com.raulexposito.model.board.BoardFixture;
import com.raulexposito.model.checker.VictoryChecker;
import org.junit.Assert;
import org.junit.Test;

import static com.raulexposito.model.Result.*;
import static com.raulexposito.model.Placement.*;
import static com.raulexposito.model.Color.*;

public class RowVictoryTest implements VictoryCheckerFixture, BoardFixture {

    @Test
    public void topRowFilled() {
        // given
        VictoryChecker victoryChecker = createVictoryChecker();
        Board board = createBoard();
        // when
        board = board
                .add(BLACK, TOP_LEFT)
                .add(BLACK, TOP_CENTER)
                .add(BLACK, TOP_RIGHT);
        // then
        Assert.assertEquals(VICTORY, victoryChecker.check(board));
    }

    @Test
    public void middleRowFilled() {
        // given
        VictoryChecker victoryChecker = createVictoryChecker();
        Board board = createBoard();
        // when
        board = board
                .add(BLACK, MIDDLE_LEFT)
                .add(BLACK, CENTER)
                .add(BLACK, MIDDLE_RIGHT);
        // then
        Assert.assertEquals(VICTORY, victoryChecker.check(board));
    }

    @Test
    public void bottomRowFilled() {
        // given
        VictoryChecker victoryChecker = createVictoryChecker();
        Board board = createBoard();
        // when
        board = board
                .add(BLACK, BOTTOM_LEFT)
                .add(BLACK, BOTTOM_CENTER)
                .add(BLACK, BOTTOM_RIGHT);
        // then
        Assert.assertEquals(VICTORY, victoryChecker.check(board));
    }
}
