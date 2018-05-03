package com.raulexposito.model.filledsquare;

import static com.raulexposito.model.Color.BLACK;
import static com.raulexposito.model.Color.WHITE;

import com.raulexposito.model.square.Square;
import org.junit.Assert;
import org.junit.Test;

public class ContentTest implements FilledSquareFixture {

    @Test
    public void blackSquareMatch() {
        // given
        Square square = createBlackFilledCell();
        // when
        boolean result = square.hasColor(BLACK);
        // then
        Assert.assertTrue(result);
    }

    @Test
    public void whiteSquareMatch() {
        // given
        Square square = createWhiteFilledCell();
        // when
        boolean result = square.hasColor(WHITE);
        // then
        Assert.assertTrue(result);
    }
}
