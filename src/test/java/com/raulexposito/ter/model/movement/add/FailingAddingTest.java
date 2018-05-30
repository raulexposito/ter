package com.raulexposito.ter.model.movement.add;

import com.raulexposito.ter.fixture.checker.AddCheckerFixture;
import com.raulexposito.ter.model.board.Board;
import com.raulexposito.ter.fixture.board.BoardFixture;
import com.raulexposito.ter.model.movement.check.AddChecker;
import com.raulexposito.ter.model.movement.execution.Execution;
import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;
import static com.raulexposito.ter.model.board.Piece.CIRCLE;
import static com.raulexposito.ter.model.board.Piece.CROSS;
import static com.raulexposito.ter.model.board.Placement.*;

public class FailingAddingTest implements AddCheckerFixture, BoardFixture {

    @Test
    public void piecesCannotBeOverlapped() {
        // given
        AddChecker addChecker = createAddChecker();
        Board board = createBoard()
                .add(CIRCLE, CENTER);

        // when
        Execution result = addChecker.check(board, CROSS, CENTER);

        // then
        assertThat(result.isFailed()).isTrue();
    }

    @Test
    public void fourEqualsPiecesCannotBeAdded() {
        // given
        AddChecker addChecker = createAddChecker();
        Board board = createBoard()
                .add(CIRCLE, TOP_LEFT)
                .add(CIRCLE, TOP_CENTER)
                .add(CIRCLE, TOP_RIGHT);

        // when
        Execution result = addChecker.check(board, CIRCLE, CENTER);

        // then
        assertThat(board.howMany(CIRCLE)).isEqualTo(3);
        assertThat(result.isFailed()).isTrue();
    }
}
