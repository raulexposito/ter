package com.raulexposito.model.board.renderer;

import com.raulexposito.helper.json.JsonPieceReader;
import com.raulexposito.helper.json.JsonStringReader;
import com.raulexposito.model.board.Board;
import com.raulexposito.model.board.BoardFixture;
import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;
import static com.raulexposito.model.board.NoContent.EMPTY;
import static com.raulexposito.model.board.Piece.CIRCLE;
import static com.raulexposito.model.board.Piece.CROSS;
import static com.raulexposito.model.board.Placement.*;

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
