package com.raulexposito.model.board.filled;

import com.raulexposito.model.board.Content;
import org.junit.Assert;
import org.junit.Test;

import static com.raulexposito.model.board.Piece.CIRCLE;
import static com.raulexposito.model.board.Piece.CROSS;

public class ContentTest implements FilledFixture {

    @Test
    public void circleContentMatch() {
        // given
        Content content = createCircleFilled();

        // when
        boolean result = content.hasPiece(CIRCLE);

        // then
        Assert.assertTrue(result);
    }

    @Test
    public void crossContentMatch() {
        // given
        Content content = createCrossFilled();

        // when
        boolean result = content.hasPiece(CROSS);

        // then
        Assert.assertTrue(result);
    }
}
