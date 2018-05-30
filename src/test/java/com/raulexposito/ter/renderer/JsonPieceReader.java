package com.raulexposito.ter.renderer;

import com.raulexposito.ter.model.board.Piece;
import com.raulexposito.ter.model.board.Placement;

import java.util.Arrays;

public interface JsonPieceReader {

    default InnerPiece thePiece(Placement key) {
        return new InnerPiece(key.toString());
    }

    class InnerPiece extends InnerResult<Piece> {

        InnerPiece(String key) {
            super(key);
        }

        @Override
        public Piece of(String json) {
            return Arrays.stream(Piece.values())
                    .filter(it -> it.toString().equals(read(json).get(key)))
                    .findFirst().get();
        }
    }
}
