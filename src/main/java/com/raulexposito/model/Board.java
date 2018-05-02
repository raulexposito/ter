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

    private Map<Placement, Cell> cells;

    // ------------------------------------------------------------------------
    // CONSTRUCTOR
    // ------------------------------------------------------------------------

    private Board() {
        this.cells = new HashMap<>(Placement.values().length);
        Arrays.stream(Placement.values()).forEach(it -> cells.put(it, new EmptyCell()));
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

    public void add(Color color, Placement placement) {
        cells.put(placement, new FilledCell(color));
    }

    public void swap(Placement current, Placement candidate) {
        cells.put(candidate, get(current));
        cells.put(current, new EmptyCell());
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
