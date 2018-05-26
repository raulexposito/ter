package com.raulexposito.model.game.result.renderer;

import com.raulexposito.helper.JsonReader;
import com.raulexposito.model.game.result.Result;
import com.raulexposito.model.game.result.VictoryFixture;
import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

public class VictoryResultRendererTest implements JsonReader, VictoryFixture {

    @Test
    public void drawnIsIncludedWithinResponse() {
        // given
        Result victory = createVictory();
        ResultRenderer renderer = new ResultRenderer(victory);

        // when
        String json = renderer.toJSON();

        // then
        assertThat(theValue("result").of(json)).isEqualTo("VICTORY");
    }
}
