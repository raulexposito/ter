package com.raulexposito.model.game.steps;

import com.raulexposito.model.board.Board;
import com.raulexposito.model.game.Steps;
import com.raulexposito.model.movement.Swap;
import org.junit.Assert;
import org.junit.Test;

import static com.raulexposito.model.board.Color.WHITE;
import static com.raulexposito.model.board.Placement.CENTER;
import static com.raulexposito.model.board.Placement.TOP_LEFT;


public class MovementsAdditionTest implements StepsFixture {

    private static final Integer MAXIMUM = 10;
    private static final Integer ONE_TO_MAXIMUM = MAXIMUM - 1;

    @Test
    public void movementsAreAddedAndNoLimitIsReached () {
        // given
        Steps steps = createLimitedSteps(MAXIMUM);

        // when
        steps = addMovements(ONE_TO_MAXIMUM, steps);

        // then
        Assert.assertFalse(steps.limitReached());
    }

    @Test
    public void movementsAreAddedAndLimitIsReached () {
        // given
        Steps steps = createLimitedSteps(MAXIMUM);

        // when
        steps = addMovements(MAXIMUM, steps);

        // then
        Assert.assertTrue(steps.limitReached());
    }

    private Steps addMovements(Integer amount, Steps steps) {
        for (int i = 0; i < amount; i++) {
            steps = steps.add(new Swap(Board.empty(), WHITE, TOP_LEFT, CENTER));
        }
        return steps;
    }
}
