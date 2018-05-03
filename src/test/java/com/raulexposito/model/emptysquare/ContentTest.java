package com.raulexposito.model.emptysquare;

import com.raulexposito.model.square.EmptySquare;
import org.junit.Assert;
import org.junit.Test;

import static com.raulexposito.model.Color.*;

public class ContentTest implements EmptySquareFixture {

    @Test
    public void emptyCellCannotIncludeBlackSquares() {
        // given
        EmptySquare cell = createEmptyCell();
        // when
        boolean result = cell.hasColor(BLACK);
        // then
        Assert.assertFalse(result);
    }

    @Test
    public void emptyCellCannotIncludeWhiteSquares() {
        // given
        EmptySquare cell = createEmptyCell();
        // when
        boolean result = cell.hasColor(WHITE);
        // then
        Assert.assertFalse(result);
    }
}
