package com.raulexposito.model.board.nocontent;

import com.raulexposito.model.board.NoContent;
import org.junit.Assert;
import org.junit.Test;

import static com.raulexposito.model.board.Piece.CIRCLE;
import static com.raulexposito.model.board.Piece.CROSS;

public class ContentTest implements NoContentFixture {

    @Test
    public void emptyContentCannotIncludeCirclePieces() {
        // given
        NoContent content = createNoContent();

        // when
        boolean result = content.hasPiece(CIRCLE);

        // then
        Assert.assertFalse(result);
    }

    @Test
    public void emptyContentCannotIncludeCrossPieces() {
        // given
        NoContent content = createNoContent();

        // when
        boolean result = content.hasPiece(CROSS);

        // then
        Assert.assertFalse(result);
    }
}
