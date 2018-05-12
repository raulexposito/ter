package com.raulexposito.model.game.checker.victory;

import com.raulexposito.model.board.Board;
import com.raulexposito.model.board.BoardFixture;
import com.raulexposito.model.game.checker.VictoryChecker;
import org.junit.Assert;
import org.junit.Test;

import static com.raulexposito.model.board.Placement.*;
import static com.raulexposito.model.Color.*;

public class NoVictoryTest implements VictoryCheckerFixture, BoardFixture {

    @Test
    public void onlyOnePiece() {
        // given
        VictoryChecker victoryChecker = createVictoryChecker();
        Board board = createBoard();
        // when
        board = board.add(BLACK, CENTER);
        // then
        Assert.assertFalse(victoryChecker.isVictory(board));
    }

    @Test
    public void notEnoughPieces() {
        // given
        VictoryChecker victoryChecker = createVictoryChecker();
        Board board = createBoard();
        // when
        board = board
                .add(BLACK, TOP_RIGHT)
                .add(BLACK, CENTER)
                .add(WHITE, BOTTOM_LEFT);
        // then
        Assert.assertFalse(victoryChecker.isVictory(board));
    }

    @Test
    public void notTheSameRow() {
        // given
        VictoryChecker victoryChecker = createVictoryChecker();
        Board board = createBoard();
        // when
        board = board
                .add(BLACK, TOP_RIGHT)
                .add(BLACK, TOP_CENTER)
                .add(BLACK, BOTTOM_LEFT);
        // then
        Assert.assertFalse(victoryChecker.isVictory(board));
    }

    @Test
    public void notTheSameColumn() {
        // given
        VictoryChecker victoryChecker = createVictoryChecker();
        Board board = createBoard();
        // when
        board = board
                .add(BLACK, TOP_LEFT)
                .add(BLACK, MIDDLE_LEFT)
                .add(BLACK, BOTTOM_RIGHT);
        // then
        Assert.assertFalse(victoryChecker.isVictory(board));
    }
}
