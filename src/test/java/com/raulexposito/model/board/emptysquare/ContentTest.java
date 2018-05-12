package com.raulexposito.model.board.emptysquare;

import com.raulexposito.model.board.EmptySquare;
import org.junit.Assert;
import org.junit.Test;

import static com.raulexposito.model.game.Color.*;

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
