package com.raulexposito.model.checker.victory;

import com.raulexposito.model.Board;
import com.raulexposito.model.board.BoardFixture;
import com.raulexposito.model.checker.VictoryChecker;
import org.junit.Assert;
import org.junit.Test;

import static com.raulexposito.model.MovementResult.*;
import static com.raulexposito.model.Placement.*;
import static com.raulexposito.model.cell.Chip.*;

public class NoVictoryTest implements VictoryCheckerFixture, BoardFixture {

    @Test
    public void onlyOneChip() {
        // given
        VictoryChecker victoryChecker = createVictoryChecker();
        Board board = createBoard();
        // when
        board.add(BLACK, CENTER);
        // then
        Assert.assertEquals(CONTINUE, victoryChecker.check(board));
    }

    @Test
    public void notEnoughChips() {
        // given
        VictoryChecker victoryChecker = createVictoryChecker();
        Board board = createBoard();
        // when
        board.add(BLACK, TOP_RIGHT);
        board.add(BLACK, CENTER);
        board.add(WHITE, BOTTOM_LEFT);
        // then
        Assert.assertEquals(CONTINUE, victoryChecker.check(board));
    }

    @Test
    public void notTheSameRow() {
        // given
        VictoryChecker victoryChecker = createVictoryChecker();
        Board board = createBoard();
        // when
        board.add(BLACK, TOP_RIGHT);
        board.add(BLACK, TOP_CENTER);
        board.add(BLACK, BOTTOM_LEFT);
        // then
        Assert.assertEquals(CONTINUE, victoryChecker.check(board));
    }

    @Test
    public void notTheSameColumn() {
        // given
        VictoryChecker victoryChecker = createVictoryChecker();
        Board board = createBoard();
        // when
        board.add(BLACK, TOP_LEFT);
        board.add(BLACK, MIDDLE_LEFT);
        board.add(BLACK, BOTTOM_RIGHT);
        // then
        Assert.assertEquals(CONTINUE, victoryChecker.check(board));
    }
}
