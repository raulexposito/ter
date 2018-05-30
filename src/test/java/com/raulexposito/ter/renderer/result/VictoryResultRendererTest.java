package com.raulexposito.ter.renderer.result;

import com.raulexposito.ter.model.game.result.Result;
import com.raulexposito.ter.fixture.game.result.VictoryFixture;
import com.raulexposito.ter.renderer.JsonStringReader;
import com.raulexposito.ter.renderer.ResultRenderer;
import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

public class VictoryResultRendererTest implements JsonStringReader, VictoryFixture {

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
