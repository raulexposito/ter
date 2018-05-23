package com.raulexposito.model.game.movements;

import com.raulexposito.model.board.Board;
import com.raulexposito.model.game.Movements;
import com.raulexposito.model.movement.Swap;
import org.junit.Assert;
import org.junit.Test;

import static com.raulexposito.model.board.Piece.CROSS;
import static com.raulexposito.model.board.Placement.CENTER;
import static com.raulexposito.model.board.Placement.TOP_LEFT;


public class MovementsAdditionTest implements MovementsFixture {

    private static final Integer MAXIMUM = 10;
    private static final Integer ONE_TO_MAXIMUM = MAXIMUM - 1;

    @Test
    public void movementsAreAddedAndNoLimitIsReached() {
        // given
        Movements movements = createLimitedSteps(MAXIMUM);

        // when
        movements = addMovements(ONE_TO_MAXIMUM, movements);

        // then
        Assert.assertFalse(movements.limitReached());
    }

    @Test
    public void movementsAreAddedAndLimitIsReached() {
        // given
        Movements movements = createLimitedSteps(MAXIMUM);

        // when
        movements = addMovements(MAXIMUM, movements);

        // then
        Assert.assertTrue(movements.limitReached());
    }

    private Movements addMovements(Integer amount, Movements movements) {
        for (int i = 0; i < amount; i++) {
            movements = movements.add(new Swap(Board.empty(), CROSS, TOP_LEFT, CENTER));
        }
        return movements;
    }
}
