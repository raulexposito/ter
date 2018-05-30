package com.raulexposito.ter.renderer.movement.add;

import com.raulexposito.ter.model.board.Board;
import com.raulexposito.ter.fixture.board.BoardFixture;
import com.raulexposito.ter.model.board.Placement;
import com.raulexposito.ter.model.movement.Add;
import com.raulexposito.ter.model.movement.Movement;
import com.raulexposito.ter.renderer.JsonMapReader;
import org.junit.Test;

import java.util.HashMap;

import static com.google.common.truth.Truth.assertThat;
import static com.raulexposito.ter.model.board.Piece.CIRCLE;
import static com.raulexposito.ter.model.board.Placement.CENTER;

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
