package com.raulexposito.ter.renderer.result;

import com.raulexposito.ter.fixture.game.result.DrawnFixture;
import com.raulexposito.ter.model.game.result.Result;
import com.raulexposito.ter.renderer.JsonStringReader;
import com.raulexposito.ter.renderer.ResultRenderer;
import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

public class DrawnResultRendererTest implements JsonStringReader, DrawnFixture {

    @Test
    public void drawnIsIncludedWithinResponse() {
        // given
        Result drawn = createDrawn();
        ResultRenderer renderer = new ResultRenderer(drawn);

        // when
        String json = renderer.toJSON();

        // then
        assertThat(theValue("result").of(json)).isEqualTo("DRAWN");
    }
}
