package com.raulexposito.model.checker;

import com.raulexposito.model.Board;
import com.raulexposito.model.board.BoardFixture;
import org.junit.Assert;
import org.junit.Test;

import static com.raulexposito.model.MovementResult.*;
import static com.raulexposito.model.Placement.*;
import static com.raulexposito.model.cell.Chip.*;

public class DiagonalVictoryTest implements VictoryCheckerFixture, BoardFixture {

    @Test
    public void topLeftToBottomRightFilled() {
        // given
        Checker victoryChecker = createVictoryChecker();
        Board board = createBoard();
        // when
        board.put(BLACK, TOP_LEFT);
        board.put(BLACK, CENTER);
        board.put(BLACK, BOTTOM_RIGHT);
        // then
        Assert.assertEquals(VICTORY, victoryChecker.check(board));
    }

    @Test
    public void topRightToBottomLeftFilled() {
        // given
        Checker victoryChecker = createVictoryChecker();
        Board board = createBoard();
        // when
        board.put(BLACK, TOP_RIGHT);
        board.put(BLACK, CENTER);
        board.put(BLACK, BOTTOM_LEFT);
        // then
        Assert.assertEquals(VICTORY, victoryChecker.check(board));
    }
}
