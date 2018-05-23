package com.raulexposito.model.game.result;

import com.raulexposito.model.board.Piece;
import com.raulexposito.model.game.Movements;
import com.raulexposito.model.player.Player;

import java.util.Optional;

public class Drawn extends Result {

    public Drawn(Movements movements, Player cross, Player circle) {
        super(movements, cross, circle);
    }

    @Override
    public boolean isDrawn() {
        return true;
    }

    @Override
    public Optional<Piece> getWinner() {
        return Optional.empty();
    }
}
