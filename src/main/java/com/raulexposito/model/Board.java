package com.raulexposito.model;

import com.raulexposito.model.cell.Cell;
import com.raulexposito.model.cell.EmptyCell;
import com.raulexposito.model.cell.FilledCell;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Board {

    // ------------------------------------------------------------------------
    // ATTRIBUTES
    // ------------------------------------------------------------------------

    private Map<Placement, Cell> cells = new HashMap<>(Placement.values().length);

    // ------------------------------------------------------------------------
    // CONSTRUCTOR
    // ------------------------------------------------------------------------

    private Board() {
        Arrays.stream(Placement.values()).forEach(it -> cells.put(it, new EmptyCell()));
    }

    private Board(Board original, Map<Placement, Cell> replacements) {
        Arrays.stream(Placement.values()).forEach(it ->
            cells.put(it, replacements.keySet()
                            .stream()
                            .findFirst()
                            .map(c -> replacements.get(it))
                            .orElse(original.get(it))));
    }

    public static Board empty() {
        return new Board();
    }

    // ------------------------------------------------------------------------
    // BUSINESS LOGIC
    // ------------------------------------------------------------------------

    public boolean isEmpty() {
        return cells.values().stream().noneMatch(Cell::isFilled);
    }

    public Board add(Color color, Placement placement) {
        return new Board(this, Map.of(placement, new FilledCell(color)));
    }

    public Board swap(Placement current, Placement candidate) {
        return new Board(this, Map.of(candidate, get(current), current, new EmptyCell()));
    }

    public Integer count(Color color) {
        return (int) cells.values().stream().filter(cell -> cell.hasColor(color)).count();
    }

    public boolean placementHasColor(Placement placement, Color color) {
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

    private Cell get(Placement placement) {
        return cells.get(placement);
    }
}
