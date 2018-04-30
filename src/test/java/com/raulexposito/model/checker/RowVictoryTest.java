package com.raulexposito.model.checker;

import com.raulexposito.model.Board;
import com.raulexposito.model.board.BoardFixture;
import org.junit.Assert;
import org.junit.Test;

import static com.raulexposito.model.MovementResult.*;
import static com.raulexposito.model.Placement.*;
import static com.raulexposito.model.cell.Chip.*;

public class RowVictoryTest implements VictoryCheckerFixture, BoardFixture {

    @Test
    public void topRowFilled() {
        // given
        Checker victoryChecker = createVictoryChecker();
        Board board = createBoard();
        // when
        board.put(BLACK, TOP_LEFT);
        board.put(BLACK, TOP_CENTER);
        board.put(BLACK, TOP_RIGHT);
        // then
        Assert.assertEquals(VICTORY, victoryChecker.check(board));
    }

    @Test
    public void middleRowFilled() {
        // given
        Checker victoryChecker = createVictoryChecker();
        Board board = createBoard();
        // when
        board.put(BLACK, MIDDLE_LEFT);
        board.put(BLACK, CENTER);
        board.put(BLACK, MIDDLE_RIGHT);
        // then
        Assert.assertEquals(VICTORY, victoryChecker.check(board));
    }

    @Test
    public void bottomRowFilled() {
        // given
        Checker victoryChecker = createVictoryChecker();
        Board board = createBoard();
        // when
        board.put(BLACK, BOTTOM_LEFT);
        board.put(BLACK, BOTTOM_CENTER);
        board.put(BLACK, BOTTOM_RIGHT);
        // then
        Assert.assertEquals(VICTORY, victoryChecker.check(board));
    }
}
