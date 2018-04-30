package com.raulexposito.model;

import com.raulexposito.model.cell.Cell;
import com.raulexposito.model.cell.Chip;
import com.raulexposito.model.cell.EmptyCell;
import com.raulexposito.model.cell.FilledCell;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Board {

    // ------------------------------------------------------------------------
    // ATTRIBUTES
    // ------------------------------------------------------------------------

    private static final Integer SAME_CHIP_MAX = 3;

    private Map<Placement, Cell> cells;

    // ------------------------------------------------------------------------
    // CONSTRUCTOR
    // ------------------------------------------------------------------------

    private Board() {
        this.cells = new HashMap<>(Placement.values().length);
        Arrays.stream(Placement.values()).forEach(it -> cells.put(it, new EmptyCell()));
    }

    public static Board with() {
        return new Board();
    }

    // ------------------------------------------------------------------------
    // BUSINESS LOGIC
    // ------------------------------------------------------------------------

    public boolean isEmpty() {
        return cells.values().stream().noneMatch(Cell::isFilled);
    }

    // TODO: crear checker específico
    public MovementResult put(Chip chip, Placement placement) {
        if (count(chip).equals(SAME_CHIP_MAX)) {
            return MovementResult.FAILURE;
        }
        final Optional<FilledCell> attempt = get(placement).fill(chip);
        return attempt.map(cell -> updateCell(placement, cell)).orElse(MovementResult.FAILURE);
    }

    // TODO: crear checker específico
    public MovementResult swap(Chip chip, Placement current, Placement candidate) {
        if (swapIsInvalid(chip, current, candidate)) {
            return MovementResult.FAILURE;
        }
        update(candidate, get(current));
        update(current, new EmptyCell());
        return MovementResult.SUCCESS;
    }

    public Integer count(Chip chip) {
        return (int) cells.values().stream().filter(cell -> cell.isChip(chip)).count();
    }

    public boolean placementHasChip (Placement placement, Chip chip) {
        return get(placement).isChip(chip);
    }

    // ------------------------------------------------------------------------
    // PRIVATE METHODS
    // ------------------------------------------------------------------------

    private Cell get(Placement placement) {
        return cells.get(placement);
    }

    private void update(Placement placement, Cell cell) {
        cells.put(placement, cell);
    }

    private MovementResult updateCell(Placement placement, FilledCell cell) {
        update(placement, cell);
        return MovementResult.SUCCESS;
    }

    private boolean swapIsInvalid(Chip chip, Placement current, Placement candidate) {
        return count(chip) < SAME_CHIP_MAX || invalidChip(current, chip) || get(current).isEmpty() || get(candidate).isFilled();
    }

    private boolean invalidChip(Placement current, Chip chip) {
        return !get(current).isChip(chip);
    }
}
