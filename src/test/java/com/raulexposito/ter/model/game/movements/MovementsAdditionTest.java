package com.raulexposito.ter.model.game.movements;

import com.raulexposito.ter.fixture.game.MovementsFixture;
import com.raulexposito.ter.model.board.Board;
import com.raulexposito.ter.model.game.Movements;
import com.raulexposito.ter.model.movement.Swap;
import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;
import static com.raulexposito.ter.model.board.Piece.CROSS;
import static com.raulexposito.ter.model.board.Placement.CENTER;
import static com.raulexposito.ter.model.board.Placement.TOP_LEFT;


public class MovementsAdditionTest implements MovementsFixture {

    private static final Integer MAXIMUM = 10;
    private static final Integer ONE_TO_MAXIMUM = MAXIMUM - 1;

    @Test
    public void movementsAreAddedAndNoLimitIsReached() {
        // given
        Movements movements = createLimitedMovements(MAXIMUM);

        // when
        movements = addMovements(ONE_TO_MAXIMUM, movements);

        // then
        assertThat(movements.limitReached()).isFalse();
    }

    @Test
    public void movementsAreAddedAndLimitIsReached() {
        // given
        Movements movements = createLimitedMovements(MAXIMUM);

        // when
        movements = addMovements(MAXIMUM, movements);

        // then
        assertThat(movements.limitReached()).isTrue();
    }

    private Movements addMovements(Integer amount, Movements movements) {
        for (int i = 0; i < amount; i++) {
            movements = movements.add(new Swap(Board.empty(), CROSS, TOP_LEFT, CENTER));
        }
        return movements;
    }
}
