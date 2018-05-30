package com.raulexposito.ter.model.board.filled;

import com.raulexposito.ter.fixture.board.FilledFixture;
import com.raulexposito.ter.model.board.Content;
import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

public class CreationTest implements FilledFixture {

    @Test
    public void contentIsNotCreatedEmpty() {
        // when
        Content content = createCircleFilled();

        // then
        assertThat(content.isEmpty()).isFalse();
    }

    @Test
    public void filledContentsCreatedFilled() {
        // when
        Content content = createCircleFilled();

        // then
        assertThat(content.isFilled()).isTrue();
    }
}
