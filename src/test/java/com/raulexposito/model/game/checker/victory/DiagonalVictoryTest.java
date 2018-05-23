package com.raulexposito.model.game.checker.victory;

import com.raulexposito.model.board.Board;
import com.raulexposito.model.board.BoardFixture;
import org.junit.Assert;
import org.junit.Test;

import static com.raulexposito.model.board.Piece.CIRCLE;
import static com.raulexposito.model.board.Placement.*;

public class DiagonalVictoryTest implements VictoryCheckerFixture, BoardFixture {

    @Test
    public void topLeftToBottomRightFilled() {
        // given
        Board board = createBoard();

        // when
        board = board
                .add(CIRCLE, TOP_LEFT)
                .add(CIRCLE, CENTER)
                .add(CIRCLE, BOTTOM_RIGHT);

        // then
        Assert.assertTrue(createVictoryChecker(board).isVictory());
    }

    @Test
    public void topRightToBottomLeftFilled() {
        // given
        Board board = createBoard();

        // when
        board = board
                .add(CIRCLE, TOP_RIGHT)
                .add(CIRCLE, CENTER)
                .add(CIRCLE, BOTTOM_LEFT);

        // then
        Assert.assertTrue(createVictoryChecker(board).isVictory());
    }
}
