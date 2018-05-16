package com.raulexposito.model.game.result;

import com.raulexposito.model.board.Piece;
import com.raulexposito.model.game.Movements;

import java.util.Optional;

public class Draw extends Result {

    public Draw(Movements movements) {
        super(movements);
    }

    @Override
    public boolean isDraw() {
        return true;
    }

    @Override
    public Optional<Piece> getWinner() {
        return Optional.empty();
    }
}
