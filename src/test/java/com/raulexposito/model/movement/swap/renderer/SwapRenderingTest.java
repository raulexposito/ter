package com.raulexposito.model.movement.swap.renderer;

import com.raulexposito.helper.json.JsonMapReader;
import com.raulexposito.model.board.Board;
import com.raulexposito.model.board.BoardFixture;
import com.raulexposito.model.board.Placement;
import com.raulexposito.model.movement.Movement;
import com.raulexposito.model.movement.Swap;
import org.junit.Test;

import java.util.HashMap;

import static com.google.common.truth.Truth.assertThat;
import static com.raulexposito.model.board.Piece.CIRCLE;
import static com.raulexposito.model.board.Placement.CENTER;
import static com.raulexposito.model.board.Placement.TOP_LEFT;

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
