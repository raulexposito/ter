package com.raulexposito.ter.renderer.board;

import com.raulexposito.ter.model.board.Board;
import com.raulexposito.ter.fixture.board.BoardFixture;
import com.raulexposito.ter.renderer.JsonPieceReader;
import com.raulexposito.ter.renderer.JsonStringReader;
import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;
import static com.raulexposito.ter.model.board.NoContent.EMPTY;
import static com.raulexposito.ter.model.board.Piece.CIRCLE;
import static com.raulexposito.ter.model.board.Piece.CROSS;
import static com.raulexposito.ter.model.board.Placement.*;

public class BoardRenderingTest implements BoardFixture, JsonPieceReader, JsonStringReader {

    @Test
    public void jsonRepresentsContent() {
        // given
        Board board = createBoard()
                .add(CIRCLE, TOP_LEFT)
                .add(CROSS, TOP_CENTER)
                .add(CIRCLE, TOP_RIGHT);

        // when
        String json = board.toJSON();

        // then
        assertThat(thePiece(TOP_LEFT).of(json)).isEqualTo(CIRCLE);
        assertThat(thePiece(TOP_CENTER).of(json)).isEqualTo(CROSS);
        assertThat(thePiece(TOP_RIGHT).of(json)).isEqualTo(CIRCLE);
        assertThat(theValue(CENTER).of(json)).isEqualTo(EMPTY);
    }
}
