package com.raulexposito.ter.model.board.nocontent;

import com.raulexposito.ter.fixture.board.NoContentFixture;
import com.raulexposito.ter.model.board.NoContent;
import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;
import static com.raulexposito.ter.model.board.Piece.CIRCLE;
import static com.raulexposito.ter.model.board.Piece.CROSS;

public class ContentTest implements NoContentFixture {

    @Test
    public void emptyContentCannotIncludeCirclePieces() {
        // given
        NoContent content = createNoContent();

        // when
        boolean result = content.hasPiece(CIRCLE);

        // then
        assertThat(result).isFalse();
    }

    @Test
    public void emptyContentCannotIncludeCrossPieces() {
        // given
        NoContent content = createNoContent();

        // when
        boolean result = content.hasPiece(CROSS);

        // then
        assertThat(result).isFalse();
    }
}
