package com.raulexposito.ter.model.movement.add;

import com.raulexposito.ter.fixture.checker.AddCheckerFixture;
import com.raulexposito.ter.model.board.Board;
import com.raulexposito.ter.fixture.board.BoardFixture;
import com.raulexposito.ter.model.movement.check.AddChecker;
import com.raulexposito.ter.model.movement.execution.Execution;
import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;
import static com.raulexposito.ter.model.board.Piece.CIRCLE;
import static com.raulexposito.ter.model.board.Placement.CENTER;

public class SuccessfulAddingTest implements AddCheckerFixture, BoardFixture {

    @Test
    public void piecesCanBeAdded() {
        // given
        AddChecker addChecker = createAddChecker();
        Board board = createBoard();

        // when
        Execution result = addChecker.check(board, CIRCLE, CENTER);

        // then
        assertThat(result.isValid()).isTrue();
    }
}
