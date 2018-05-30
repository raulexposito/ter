package com.raulexposito.ter.model.game.result;

import com.raulexposito.ter.model.board.Piece;
import com.raulexposito.ter.model.game.Movements;
import com.raulexposito.ter.model.player.Player;

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
