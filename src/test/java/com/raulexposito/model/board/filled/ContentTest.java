package com.raulexposito.model.board.filled;

import com.raulexposito.model.board.Content;
import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;
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
        assertThat(result).isTrue();
    }

    @Test
    public void crossContentMatch() {
        // given
        Content content = createCrossFilled();

        // when
        boolean result = content.hasPiece(CROSS);

        // then
        assertThat(result).isTrue();
    }
}
