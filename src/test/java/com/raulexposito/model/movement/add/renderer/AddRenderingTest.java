package com.raulexposito.model.movement.add.renderer;

import com.raulexposito.helper.JsonReader;
import com.raulexposito.model.board.Board;
import com.raulexposito.model.board.BoardFixture;
import com.raulexposito.model.movement.Add;
import com.raulexposito.model.movement.Movement;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

import static com.raulexposito.model.board.Piece.CIRCLE;
import static com.raulexposito.model.board.Placement.CENTER;

public class AddRenderingTest implements BoardFixture, JsonReader {

    @Test
    public void jsonRepresentsContent() {
        // given
        Board board = createBoard();
        Movement movement = new Add(board, CIRCLE, CENTER);

        // when
        String json = movement.toJSON();

        // then
        Assert.assertTrue(contains(json, "add", new HashMap<String, String>() {{
            put("to", CENTER.toString());
        }}));
    }
}
