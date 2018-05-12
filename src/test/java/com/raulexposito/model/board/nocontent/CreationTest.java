package com.raulexposito.model.board.nocontent;

import com.raulexposito.model.board.NoContent;
import org.junit.Assert;
import org.junit.Test;

public class CreationTest implements NoContentFixture {

    @Test
    public void contentIsCreatedEmpty() {
        // when
        NoContent content = createNoContent();
        // then
        Assert.assertTrue(content.isEmpty());
    }

    @Test
    public void emptyContentIsNotCreatedFilled() {
        // when
        NoContent content = createNoContent();
        // then
        Assert.assertFalse(content.isFilled());
    }
}
