package com.raulexposito.model.board;

import com.raulexposito.model.Board;
import com.raulexposito.model.MovementResult;
import org.junit.Assert;
import org.junit.Test;

import static com.raulexposito.model.Placement.*;
import static com.raulexposito.model.cell.Chip.*;

public class SwappinessTest implements BoardFixture {

    @Test
    public void chipsCanBeSwapped() {
        // given
        Board board = createBoard();
        board.put(BLACK, TOP_LEFT);
        board.put(BLACK, TOP_CENTER);
        board.put(BLACK, TOP_RIGHT);
        // when
        MovementResult result = board.swap(BLACK, TOP_LEFT, CENTER);
        // then
        Assert.assertEquals(Integer.valueOf(3), board.count(BLACK));
        Assert.assertEquals(MovementResult.SUCCESS, result);
    }

    @Test
    public void cannotSwapDifferentChips() {
        // given
        Board board = createBoard();
        board.put(BLACK, TOP_LEFT);
        board.put(BLACK, TOP_CENTER);
        board.put(BLACK, TOP_RIGHT);
        // when
        MovementResult result = board.swap(WHITE, TOP_LEFT, TOP_CENTER);
        // then
        Assert.assertEquals(MovementResult.FAILURE, result);
    }

    @Test
    public void min3ChipsToSwap() {
        // given
        Board board = createBoard();
        board.put(BLACK, TOP_LEFT);
        board.put(BLACK, TOP_CENTER);
        // when
        MovementResult result = board.swap(BLACK, TOP_LEFT, CENTER);
        // then
        Assert.assertEquals(Integer.valueOf(2), board.count(BLACK));
        Assert.assertEquals(MovementResult.FAILURE, result);
    }

    @Test
    public void emptyPlacementsCannotBeSwapped() {
        // given
        Board board = createBoard();
        board.put(BLACK, TOP_LEFT);
        board.put(BLACK, TOP_CENTER);
        board.put(BLACK, TOP_RIGHT);
        // when
        MovementResult result = board.swap(BLACK, CENTER, BOTTOM_CENTER);
        // then
        Assert.assertEquals(MovementResult.FAILURE, result);
    }

    @Test
    public void cannotSwapToFilledPlacements() {
        // given
        Board board = createBoard();
        board.put(BLACK, TOP_LEFT);
        board.put(BLACK, TOP_CENTER);
        board.put(BLACK, TOP_RIGHT);
        // when
        MovementResult result = board.swap(BLACK, TOP_LEFT, TOP_RIGHT);
        // then
        Assert.assertEquals(MovementResult.FAILURE, result);
    }
}
