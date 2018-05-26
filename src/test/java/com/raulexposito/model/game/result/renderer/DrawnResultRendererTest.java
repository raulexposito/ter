package com.raulexposito.model.game.result.renderer;

import com.raulexposito.helper.JsonReader;
import com.raulexposito.model.game.result.DrawnFixture;
import com.raulexposito.model.game.result.Result;
import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

public class DrawnResultRendererTest implements JsonReader, DrawnFixture {

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
