package com.raulexposito.model.board.renderer;

import com.raulexposito.helper.JsonReader;
import com.raulexposito.model.board.Board;
import com.raulexposito.model.board.BoardFixture;
import com.raulexposito.model.board.NoContent;
import org.junit.Assert;
import org.junit.Test;

import static com.raulexposito.model.board.Piece.CIRCLE;
import static com.raulexposito.model.board.Piece.CROSS;
import static com.raulexposito.model.board.Placement.*;

public class BoardRenderingTest implements BoardFixture, JsonReader {

    @Test
    public void jsonRepresentsContent() {
        // given
        Board board = createBoard()
                .add(CIRCLE, TOP_LEFT)
                .add(CROSS, TOP_CENTER)
                .add(CIRCLE, TOP_RIGHT);

        // when
        String json = board.toJSON();

        // then
        Assert.assertTrue(contains(json, TOP_LEFT, CIRCLE));
        Assert.assertTrue(contains(json, TOP_CENTER, CROSS));
        Assert.assertTrue(contains(json, TOP_RIGHT, CIRCLE));
        Assert.assertTrue(contains(json, CENTER, NoContent.EMPTY));
    }
}
