package com.raulexposito.model.board.nocontent;

import com.raulexposito.model.board.NoContent;
import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

public class CreationTest implements NoContentFixture {

    @Test
    public void contentIsCreatedEmpty() {
        // when
        NoContent content = createNoContent();

        // then
        assertThat(content.isEmpty()).isTrue();
    }

    @Test
    public void emptyContentIsNotCreatedFilled() {
        // when
        NoContent content = createNoContent();

        // then
        assertThat(content.isFilled()).isFalse();
    }
}
