package com.raulexposito.model.movement.swap;

import com.raulexposito.model.board.Board;
import com.raulexposito.model.board.BoardFixture;
import com.raulexposito.model.movement.Movement;
import com.raulexposito.model.movement.Swap;
import org.junit.Assert;
import org.junit.Test;

import static com.raulexposito.model.board.Placement.*;
import static com.raulexposito.model.Color.BLACK;

public class SwappingIsVictoryTest implements BoardFixture {

    @Test
    public void swappingIsVictory() {
        // given
        Board board = createBoard()
                .add(BLACK, TOP_LEFT)
                .add(BLACK, TOP_CENTER)
                .add(BLACK, CENTER);
        // when
        Movement movement = new Swap(board, BLACK, CENTER, TOP_RIGHT);
        // then
        Assert.assertTrue(movement.isVictory());
    }
}