package com.raulexposito.ter.model.game.result;

import com.raulexposito.ter.model.board.Piece;
import com.raulexposito.ter.model.game.Movements;
import com.raulexposito.ter.model.player.Player;
import com.raulexposito.ter.renderer.ResultRenderer;

import java.util.Optional;

public abstract class Result {

    // ------------------------------------------------------------------------
    // ATTRIBUTES
    // ------------------------------------------------------------------------

    private final Movements movements;
    private final Player cross;
    private final Player circle;

    // ------------------------------------------------------------------------
    // CONSTRUCTOR
    // ------------------------------------------------------------------------

    Result(Movements movements, Player cross, Player circle) {
        this.movements = movements;
        this.cross = cross;
        this.circle = circle;
    }

    // ------------------------------------------------------------------------
    // ABSTRACT METHODS
    // ------------------------------------------------------------------------

    public abstract Optional<Piece> getWinner();

    // ------------------------------------------------------------------------
    // BUSINESS LOGIC
    // ------------------------------------------------------------------------

    public boolean isVictory() {
        return false;
    }

    public Integer getMovementsLength() {
        return movements.length();
    }

    public String getCrossPlayerName() {
        return cross.getName().toUpperCase();
    }

    public String getCirclePlayerName() {
        return circle.getName().toUpperCase();
    }

    public String getMovementsAsJSON() {
        return movements.toJSON();
    }

    public boolean isDrawn() {
        return false;
    }

    public String toJSON() {
        return new ResultRenderer(this).toJSON();
    }
}
