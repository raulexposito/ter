package com.raulexposito.model.board;

import com.raulexposito.model.Board;
import com.raulexposito.model.MovementResult;
import org.junit.Assert;
import org.junit.Test;

import static com.raulexposito.model.Placement.*;
import static com.raulexposito.model.cell.Chip.*;

public class ChipsAdditionTest implements BoardFixture {

    @Test
    public void chipsCanBeAdded() {
        // given
        Board board = createBoard();
        // when
        MovementResult result = board.put(BLACK, CENTER);
        // then
        Assert.assertEquals(MovementResult.SUCCESS, result);
    }

    @Test
    public void chipsCannotBeOverlapped() {
        // given
        Board board = createBoard();
        board.put(BLACK, CENTER);
        // when
        MovementResult result = board.put(WHITE, CENTER);
        // then
        Assert.assertEquals(MovementResult.FAILURE, result);
    }

    @Test
    public void fourEqualsChipsCannotBeAdded() {
        // given
        Board board = createBoard();
        board.put(BLACK, TOP_LEFT);
        board.put(BLACK, TOP_CENTER);
        board.put(BLACK, TOP_RIGHT);
        // when
        MovementResult result = board.put(BLACK, CENTER);
        // then
        Assert.assertEquals(Integer.valueOf(3), board.count(BLACK));
        Assert.assertEquals(MovementResult.FAILURE, result);
    }
}
