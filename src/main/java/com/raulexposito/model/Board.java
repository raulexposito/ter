package com.raulexposito.model;

import com.raulexposito.model.square.Square;
import com.raulexposito.model.square.EmptySquare;
import com.raulexposito.model.square.FilledSquare;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Board {

    // ------------------------------------------------------------------------
    // ATTRIBUTES
    // ------------------------------------------------------------------------

    private Map<Placement, Square> squares = new HashMap<>(Placement.values().length);

    // ------------------------------------------------------------------------
    // CONSTRUCTOR
    // ------------------------------------------------------------------------

    private Board() {
        Arrays.stream(Placement.values()).forEach(it -> squares.put(it, new EmptySquare()));
    }

    private Board(Board original, PlacementSquare ... placementSquares) {
        Arrays.stream(Placement.values()).forEach(placement ->
            squares.put(placement, Arrays.stream(placementSquares)
                    .filter(placementSquare -> placement == placementSquare.placement)
                    .findFirst()
                    .map(placementSquare -> placementSquare.square)
                    .orElse(original.get(placement))));
    }

    public static Board empty() {
        return new Board();
    }

    // ------------------------------------------------------------------------
    // BUSINESS LOGIC
    // ------------------------------------------------------------------------

    public Board add(Color color, Placement placement) {
        return new Board(this,
                new PlacementSquare(placement, new FilledSquare(color)));
    }

    public Board swap(Placement current, Placement candidate) {
        return new Board(this,
                new PlacementSquare(candidate, get(current)),
                new PlacementSquare(current, new EmptySquare()));
    }

    // ------------------------------------------------------------------------
    // PUBLIC METHODS
    // ------------------------------------------------------------------------

    public boolean isEmpty() {
        return squares.values().stream().noneMatch(Square::isFilled);
    }

    public Integer howMany(Color color) {
        return (int) squares.values().stream().filter(cell -> cell.hasColor(color)).count();
    }

    public boolean squareHasColor(Placement placement, Color color) {
        return get(placement).hasColor(color);
    }

    public boolean isPlacementEmpty(Placement placement) {
        return get(placement).isEmpty();
    }

    public boolean isPlacementFilled(Placement placement) {
        return get(placement).isFilled();
    }

    // ------------------------------------------------------------------------
    // PRIVATE METHODS
    // ------------------------------------------------------------------------

    private Square get(Placement placement) {
        return squares.get(placement);
    }

    // ------------------------------------------------------------------------
    // INNER CLASS
    // ------------------------------------------------------------------------

    private class PlacementSquare {
        Placement placement;
        Square square;

        PlacementSquare(Placement placement, Square square) {
            this.placement = placement;
            this.square = square;
        }
    }
}
