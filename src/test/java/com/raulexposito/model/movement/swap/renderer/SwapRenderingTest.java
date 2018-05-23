package com.raulexposito.model.movement.swap.renderer;

import com.raulexposito.helper.JsonReader;
import com.raulexposito.model.board.Board;
import com.raulexposito.model.board.BoardFixture;
import com.raulexposito.model.movement.Movement;
import com.raulexposito.model.movement.Swap;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

import static com.raulexposito.model.board.Piece.CIRCLE;
import static com.raulexposito.model.board.Placement.CENTER;
import static com.raulexposito.model.board.Placement.TOP_LEFT;

public class SwapRenderingTest implements BoardFixture, JsonReader {

    @Test
    public void jsonRepresentsContent() {
        // given
        Board board = createBoard().add(CIRCLE, CENTER);
        Movement movement = new Swap(board, CIRCLE, CENTER, TOP_LEFT);

        // when
        String json = movement.toJSON();

        // then
        Assert.assertTrue(contains(json, "swap", new HashMap<String, String>() {{
            put("from", CENTER.toString());
            put("to", TOP_LEFT.toString());
        }}));
    }
}
