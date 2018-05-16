package com.raulexposito.model.board.filled;

import com.raulexposito.model.board.Content;
import org.junit.Assert;
import org.junit.Test;

public class CreationTest implements FilledFixture {

    @Test
    public void contentIsNotCreatedEmpty() {
        // when
        Content content = createCircleFilled();
        // then
        Assert.assertFalse(content.isEmpty());
    }

    @Test
    public void filledContentsCreatedFilled() {
        // when
        Content content = createCircleFilled();
        // then
        Assert.assertTrue(content.isFilled());
    }
}
