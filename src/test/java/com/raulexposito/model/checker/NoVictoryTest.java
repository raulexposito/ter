package com.raulexposito.model.checker;

import com.raulexposito.model.Board;
import com.raulexposito.model.board.BoardFixture;
import org.junit.Assert;
import org.junit.Test;

import static com.raulexposito.model.MovementResult.*;
import static com.raulexposito.model.Placement.*;
import static com.raulexposito.model.cell.Chip.*;

public class NoVictoryTest implements VictoryCheckerFixture, BoardFixture {

    @Test
    public void onlyOneChip() {
        // given
        Checker victoryChecker = createVictoryChecker();
        Board board = createBoard();
        // when
        board.put(BLACK, CENTER);
        // then
        Assert.assertEquals(CONTINUE, victoryChecker.check(board));
    }

    @Test
    public void notEnoughChips() {
        // given
        Checker victoryChecker = createVictoryChecker();
        Board board = createBoard();
        // when
        board.put(BLACK, TOP_RIGHT);
        board.put(BLACK, CENTER);
        board.put(WHITE, BOTTOM_LEFT);
        // then
        Assert.assertEquals(CONTINUE, victoryChecker.check(board));
    }

    @Test
    public void notTheSameRow() {
        // given
        Checker victoryChecker = createVictoryChecker();
        Board board = createBoard();
        // when
        board.put(BLACK, TOP_RIGHT);
        board.put(BLACK, TOP_CENTER);
        board.put(BLACK, BOTTOM_LEFT);
        // then
        Assert.assertEquals(CONTINUE, victoryChecker.check(board));
    }

    @Test
    public void notTheSameColumn() {
        // given
        Checker victoryChecker = createVictoryChecker();
        Board board = createBoard();
        // when
        board.put(BLACK, TOP_LEFT);
        board.put(BLACK, MIDDLE_LEFT);
        board.put(BLACK, BOTTOM_RIGHT);
        // then
        Assert.assertEquals(CONTINUE, victoryChecker.check(board));
    }

}
