package com.raulexposito.model;

import com.raulexposito.model.cell.Cell;
import com.raulexposito.model.cell.Chip;
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

    public void add(Chip chip, Placement placement) {
        cells.put(placement, new FilledCell(chip));
    }

    public void swap(Placement current, Placement candidate) {
        cells.put(candidate, get(current));
        cells.put(current, new EmptyCell());
    }

    public Integer count(Chip chip) {
        return (int) cells.values().stream().filter(cell -> cell.isChip(chip)).count();
    }

    public boolean placementHasChip (Placement placement, Chip chip) {
        return get(placement).isChip(chip);
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
