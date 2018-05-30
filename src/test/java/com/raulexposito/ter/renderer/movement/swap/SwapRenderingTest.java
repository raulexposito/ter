package com.raulexposito.ter.renderer.movement.swap;

import com.raulexposito.ter.model.board.Board;
import com.raulexposito.ter.fixture.board.BoardFixture;
import com.raulexposito.ter.model.board.Placement;
import com.raulexposito.ter.model.movement.Movement;
import com.raulexposito.ter.model.movement.Swap;
import com.raulexposito.ter.renderer.JsonMapReader;
import org.junit.Test;

import java.util.HashMap;

import static com.google.common.truth.Truth.assertThat;
import static com.raulexposito.ter.model.board.Piece.CIRCLE;
import static com.raulexposito.ter.model.board.Placement.CENTER;
import static com.raulexposito.ter.model.board.Placement.TOP_LEFT;

public class SwapRenderingTest implements BoardFixture, JsonMapReader {

    @Test
    public void jsonRepresentsContent() {
        // given
        Board board = createBoard().add(CIRCLE, CENTER);
        Movement movement = new Swap(board, CIRCLE, CENTER, TOP_LEFT);

        // when
        String json = movement.toJSON();

        // then
        assertThat(theMappingValue("swap").of(json)).isEqualTo(new HashMap<String, Placement>() {{
            put("from", CENTER);
            put("to", TOP_LEFT);
        }});
    }
}
