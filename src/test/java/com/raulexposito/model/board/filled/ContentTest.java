package com.raulexposito.model.board.filled;

import static com.raulexposito.model.board.Color.BLACK;
import static com.raulexposito.model.board.Color.WHITE;

import com.raulexposito.model.board.Content;
import org.junit.Assert;
import org.junit.Test;

public class ContentTest implements FilledFixture {

    @Test
    public void blackContentMatch() {
        // given
        Content content = createBlackFilled();
        // when
        boolean result = content.hasColor(BLACK);
        // then
        Assert.assertTrue(result);
    }

    @Test
    public void whiteContentMatch() {
        // given
        Content content = createWhiteFilled();
        // when
        boolean result = content.hasColor(WHITE);
        // then
        Assert.assertTrue(result);
    }
}
