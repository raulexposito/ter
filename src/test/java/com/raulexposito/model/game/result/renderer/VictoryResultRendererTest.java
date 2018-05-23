package com.raulexposito.model.game.result.renderer;

import com.raulexposito.helper.JsonReader;
import com.raulexposito.model.game.result.Result;
import com.raulexposito.model.game.result.VictoryFixture;
import org.junit.Assert;
import org.junit.Test;

public class VictoryResultRendererTest implements JsonReader, VictoryFixture {

    @Test
    public void drawnIsIncludedWithinResponse() {
        // given
        Result victory = createVictory();
        ResultRenderer renderer = new ResultRenderer(victory);

        // when
        String json = renderer.toJSON();

        // then
        Assert.assertTrue(contains(json, "result", "VICTORY"));
    }
}
