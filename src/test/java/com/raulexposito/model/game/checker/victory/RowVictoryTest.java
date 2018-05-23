package com.raulexposito.model.game.checker.victory;

import com.raulexposito.model.board.Board;
import com.raulexposito.model.board.BoardFixture;
import org.junit.Assert;
import org.junit.Test;

import static com.raulexposito.model.board.Piece.CIRCLE;
import static com.raulexposito.model.board.Placement.*;

public class RowVictoryTest implements VictoryCheckerFixture, BoardFixture {

    @Test
    public void topRowFilled() {
        // given
        Board board = createBoard();

        // when
        board = board
                .add(CIRCLE, TOP_LEFT)
                .add(CIRCLE, TOP_CENTER)
                .add(CIRCLE, TOP_RIGHT);

        // then
        Assert.assertTrue(createVictoryChecker(board).isVictory());
    }

    @Test
    public void middleRowFilled() {
        // given
        Board board = createBoard();

        // when
        board = board
                .add(CIRCLE, MIDDLE_LEFT)
                .add(CIRCLE, CENTER)
                .add(CIRCLE, MIDDLE_RIGHT);

        // then
        Assert.assertTrue(createVictoryChecker(board).isVictory());
    }

    @Test
    public void bottomRowFilled() {
        // given
        Board board = createBoard();

        // when
        board = board
                .add(CIRCLE, BOTTOM_LEFT)
                .add(CIRCLE, BOTTOM_CENTER)
                .add(CIRCLE, BOTTOM_RIGHT);

        // then
        Assert.assertTrue(createVictoryChecker(board).isVictory());
    }
}
