package com.raulexposito.model.board.nocontent;

import com.raulexposito.model.board.NoContent;
import org.junit.Assert;
import org.junit.Test;

import static com.raulexposito.model.game.Color.*;

public class ContentTest implements NoContentFixture {

    @Test
    public void emptyContentCannotIncludeBlackSquares() {
        // given
        NoContent content = createNoContent();
        // when
        boolean result = content.hasColor(BLACK);
        // then
        Assert.assertFalse(result);
    }

    @Test
    public void emptyContentCannotIncludeWhiteSquares() {
        // given
        NoContent content = createNoContent();
        // when
        boolean result = content.hasColor(WHITE);
        // then
        Assert.assertFalse(result);
    }
}
