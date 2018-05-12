package com.raulexposito.model.board;

import com.raulexposito.model.Color;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Board {

    // ------------------------------------------------------------------------
    // ATTRIBUTES
    // ------------------------------------------------------------------------

    private final Map<Placement, Content> squares = new HashMap<>(Placement.values().length);

    // ------------------------------------------------------------------------
    // CONSTRUCTOR
    // ------------------------------------------------------------------------

    private Board() {
        Arrays.stream(Placement.values()).forEach(it -> squares.put(it, new NoContent()));
    }

    private Board(Board original, Square... squares) {
        Arrays.stream(Placement.values()).forEach(placement ->
            this.squares.put(placement, Arrays.stream(squares)
                    .filter(square -> placement == square.placement)
                    .findFirst()
                    .map(square -> square.content)
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
                new Square(placement, new Filled(color)));
    }

    public Board swap(Placement current, Placement candidate) {
        return new Board(this,
                new Square(candidate, get(current)),
                new Square(current, new NoContent()));
    }

    // ------------------------------------------------------------------------
    // PUBLIC METHODS
    // ------------------------------------------------------------------------

    public Long howMany(Color color) {
        return squares.values().stream().filter(content -> content.hasColor(color)).count();
    }

    public boolean hasColor(Placement placement, Color color) {
        return get(placement).hasColor(color);
    }

    public boolean isEmpty(Placement placement) {
        return get(placement).isEmpty();
    }

    public boolean isFilled(Placement placement) {
        return get(placement).isFilled();
    }

    @Override
    public String toString() {
        return "\n" +
                squares.get(Placement.TOP_LEFT) +
                squares.get(Placement.TOP_CENTER) +
                squares.get(Placement.TOP_RIGHT) +
                "\n" +
                squares.get(Placement.MIDDLE_LEFT) +
                squares.get(Placement.CENTER) +
                squares.get(Placement.MIDDLE_RIGHT) +
                "\n" +
                squares.get(Placement.BOTTOM_LEFT) +
                squares.get(Placement.BOTTOM_CENTER) +
                squares.get(Placement.BOTTOM_RIGHT) +
                "\n" +
                "-----";
    }

    // ------------------------------------------------------------------------
    // PRIVATE METHODS
    // ------------------------------------------------------------------------

    private Content get(Placement placement) {
        return squares.get(placement);
    }

    // ------------------------------------------------------------------------
    // INNER CLASS
    // ------------------------------------------------------------------------

    private class Square {
        final Placement placement;
        final Content content;

        Square(Placement placement, Content content) {
            this.placement = placement;
            this.content = content;
        }
    }
}
