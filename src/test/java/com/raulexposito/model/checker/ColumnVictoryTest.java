package com.raulexposito.model.checker;

import com.raulexposito.model.Board;
import com.raulexposito.model.board.BoardFixture;
import org.junit.Assert;
import org.junit.Test;

import static com.raulexposito.model.MovementResult.*;
import static com.raulexposito.model.Placement.*;
import static com.raulexposito.model.cell.Chip.*;

public class ColumnVictoryTest implements VictoryCheckerFixture, BoardFixture {

    @Test
    public void leftColumnFilled() {
        // given
        Checker victoryChecker = createVictoryChecker();
        Board board = createBoard();
        // when
        board.put(BLACK, TOP_LEFT);
        board.put(BLACK, MIDDLE_LEFT);
        board.put(BLACK, BOTTOM_LEFT);
        // then
        Assert.assertEquals(VICTORY, victoryChecker.check(board));
    }

    @Test
    public void middleColumnFilled() {
        // given
        Checker victoryChecker = createVictoryChecker();
        Board board = createBoard();
        // when
        board.put(BLACK, TOP_CENTER);
        board.put(BLACK, CENTER);
        board.put(BLACK, BOTTOM_CENTER);
        // then
        Assert.assertEquals(VICTORY, victoryChecker.check(board));
    }

    @Test
    public void rightColumnFilled() {
        // given
        Checker victoryChecker = createVictoryChecker();
        Board board = createBoard();
        // when
        board.put(BLACK, TOP_RIGHT);
        board.put(BLACK, MIDDLE_RIGHT);
        board.put(BLACK, BOTTOM_RIGHT);
        // then
        Assert.assertEquals(VICTORY, victoryChecker.check(board));
    }
}
