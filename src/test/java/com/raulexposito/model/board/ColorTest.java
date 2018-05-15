package com.raulexposito.model.board;

import org.junit.Assert;
import org.junit.Test;

import static com.raulexposito.model.board.Color.BLACK;
import static com.raulexposito.model.board.Color.WHITE;

public class ColorTest {

    @Test
    public void blacksOppositeIsWhite () {
        // given
        Color color = BLACK;
        // when
        Color opposite = color.getOpposite();
        // then
        Assert.assertEquals(WHITE, opposite);
    }

    @Test
    public void whitesOppositeIsBlack () {
        // given
        Color color = WHITE;
        // when
        Color opposite = color.getOpposite();
        // then
        Assert.assertEquals(BLACK, opposite);
    }

}
