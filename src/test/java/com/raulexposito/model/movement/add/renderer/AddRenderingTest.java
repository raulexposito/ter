package com.raulexposito.model.movement.add.renderer;

import com.raulexposito.helper.json.JsonMapReader;
import com.raulexposito.model.board.Board;
import com.raulexposito.model.board.BoardFixture;
import com.raulexposito.model.board.Placement;
import com.raulexposito.model.movement.Add;
import com.raulexposito.model.movement.Movement;
import org.junit.Test;

import java.util.HashMap;

import static com.google.common.truth.Truth.assertThat;
import static com.raulexposito.model.board.Piece.CIRCLE;
import static com.raulexposito.model.board.Placement.CENTER;

public class AddRenderingTest implements BoardFixture, JsonMapReader {

    @Test
    public void jsonRepresentsContent() {
        // given
        Board board = createBoard();
        Movement movement = new Add(board, CIRCLE, CENTER);

        // when
        String json = movement.toJSON();

        // then
        assertThat(theMappingValue("add").of(json)).isEqualTo(new HashMap<String, Placement>() {{
            put("to", CENTER);
        }});
    }
}
