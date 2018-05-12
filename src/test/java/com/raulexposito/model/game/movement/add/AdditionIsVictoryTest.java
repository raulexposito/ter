package com.raulexposito.model.game.movement.add;

import com.raulexposito.model.board.Board;
import com.raulexposito.model.board.BoardFixture;
import com.raulexposito.model.game.movement.Add;
import com.raulexposito.model.game.movement.Movement;
import org.junit.Assert;
import org.junit.Test;

import static com.raulexposito.model.board.Placement.*;
import static com.raulexposito.model.game.Color.BLACK;

public class AdditionIsVictoryTest implements BoardFixture {

    @Test
    public void additionIsDone() {
        // given
        Board board = createBoard()
                .add(BLACK, TOP_LEFT)
                .add(BLACK, TOP_CENTER);
        // when
        Movement movement = new Add(board, BLACK, TOP_RIGHT);
        // then
        Assert.assertTrue(movement.isVictory());
    }
}