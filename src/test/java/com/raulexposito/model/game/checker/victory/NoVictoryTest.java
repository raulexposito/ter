package com.raulexposito.model.game.checker.victory;

import com.raulexposito.model.board.Board;
import com.raulexposito.model.board.BoardFixture;
import com.raulexposito.model.game.checker.VictoryChecker;
import org.junit.Assert;
import org.junit.Test;

import static com.raulexposito.model.board.Piece.CIRCLE;
import static com.raulexposito.model.board.Piece.CROSS;
import static com.raulexposito.model.board.Placement.*;

public class NoVictoryTest implements VictoryCheckerFixture, BoardFixture {

    @Test
    public void onlyOnePiece() {
        // given
        VictoryChecker victoryChecker = createVictoryChecker();
        Board board = createBoard();
        // when
        board = board.add(CIRCLE, CENTER);
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
                .add(CIRCLE, TOP_RIGHT)
                .add(CIRCLE, CENTER)
                .add(CROSS, BOTTOM_LEFT);
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
                .add(CIRCLE, TOP_RIGHT)
                .add(CIRCLE, TOP_CENTER)
                .add(CIRCLE, BOTTOM_LEFT);
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
                .add(CIRCLE, TOP_LEFT)
                .add(CIRCLE, MIDDLE_LEFT)
                .add(CIRCLE, BOTTOM_RIGHT);
        // then
        Assert.assertFalse(victoryChecker.isVictory(board));
    }
}
