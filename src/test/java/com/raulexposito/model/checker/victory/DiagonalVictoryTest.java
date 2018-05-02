package com.raulexposito.model.checker.victory;

import com.raulexposito.model.Board;
import com.raulexposito.model.board.BoardFixture;
import com.raulexposito.model.checker.VictoryChecker;
import org.junit.Assert;
import org.junit.Test;

import static com.raulexposito.model.Result.*;
import static com.raulexposito.model.Placement.*;
import static com.raulexposito.model.Color.*;

public class DiagonalVictoryTest implements VictoryCheckerFixture, BoardFixture {

    @Test
    public void topLeftToBottomRightFilled() {
        // given
        VictoryChecker victoryChecker = createVictoryChecker();
        Board board = createBoard();
        // when
        board.add(BLACK, TOP_LEFT);
        board.add(BLACK, CENTER);
        board.add(BLACK, BOTTOM_RIGHT);
        // then
        Assert.assertEquals(VICTORY, victoryChecker.check(board));
    }

    @Test
    public void topRightToBottomLeftFilled() {
        // given
        VictoryChecker victoryChecker = createVictoryChecker();
        Board board = createBoard();
        // when
        board.add(BLACK, TOP_RIGHT);
        board.add(BLACK, CENTER);
        board.add(BLACK, BOTTOM_LEFT);
        // then
        Assert.assertEquals(VICTORY, victoryChecker.check(board));
    }
}
