package com.raulexposito.ter.model.player;

import com.raulexposito.ter.model.board.Board;
import com.raulexposito.ter.model.board.Piece;
import com.raulexposito.ter.model.board.Placement;
import com.raulexposito.ter.model.movement.Add;
import com.raulexposito.ter.model.movement.Movement;
import com.raulexposito.ter.model.movement.Swap;

import java.util.List;

public abstract class Player {

    // ------------------------------------------------------------------------
    // ATTRIBUTES
    // ------------------------------------------------------------------------

    private final Piece piece;
    private final String name;
    private Board board;
    private Environment environment;

    // ------------------------------------------------------------------------
    // CONSTRUCTOR
    // ------------------------------------------------------------------------

    public Player(Piece piece, String name) {
        this.piece = piece;
        this.name = name;
    }

    // ------------------------------------------------------------------------
    // BUSINESS LOGIC
    // ------------------------------------------------------------------------

    public Movement move(Board board) {
        this.board = board;
        this.environment = new Environment(board, piece);
        return move();
    }

    public abstract Movement move();

    public String getName() {
        return name;
    }

    // ------------------------------------------------------------------------
    // PROTECTED METHODS
    // ------------------------------------------------------------------------

    protected Movement add(Placement placement) {
        return new Add(board, piece, placement);
    }

    protected Movement swap(Placement current, Placement candidate) {
        return new Swap(board, piece, current, candidate);
    }

    protected boolean canAdd() {
        return environment.canAdd();
    }

    protected List<Placement> mySquares() {
        return environment.mySquares();
    }

    protected List<Placement> rivalSquares() {
        return environment.rivalSquares();
    }

    protected List<Placement> emptySquares() {
        return environment.emptySquares();
    }
}
