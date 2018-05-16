package com.raulexposito.model.game.result;

import com.raulexposito.model.board.Piece;
import com.raulexposito.model.game.Movements;

import java.util.Optional;

public class Drawn extends Result {

    public Drawn(Movements movements) {
        super(movements);
    }

    @Override
    public boolean isDrawn() {
        return true;
    }

    @Override
    public Optional<Piece> getWinner() {
        return Optional.empty();
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("{");
        builder.append("\"result\": \"DRAWN\",");
        builder.append(movementsAsJSON());
        builder.append("}");
        return builder.toString();
    }
}
