package com.raulexposito.model.player;

import com.raulexposito.model.board.Board;
import com.raulexposito.model.board.Piece;
import com.raulexposito.model.board.Placement;
import com.raulexposito.model.movement.Add;
import com.raulexposito.model.movement.Movement;
import com.raulexposito.model.movement.Swap;

import java.util.List;

public abstract class Player {

    // ------------------------------------------------------------------------
    // ATTRIBUTES
    // ------------------------------------------------------------------------

    private final Piece piece;
    private final String name;
    private Board board;
    private Knowledge knowledge;

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
        this.knowledge = new Knowledge(board, piece);
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
        return knowledge.canAdd();
    }

    protected List<Placement> mySquares() {
        return knowledge.mySquares();
    }

    protected List<Placement> rivalSquares() {
        return knowledge.rivalSquares();
    }

    protected List<Placement> emptySquares() {
        return knowledge.emptySquares();
    }
}
