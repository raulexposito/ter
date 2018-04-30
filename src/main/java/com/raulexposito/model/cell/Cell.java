package com.raulexposito.model.cell;

import java.util.Optional;

public abstract class Cell {

    // ------------------------------------------------------------------------
    // ABSTRACT METHODS
    // ------------------------------------------------------------------------

    public abstract boolean isFilled();

    public abstract Optional<FilledCell> fill (Chip chip);

    public abstract Optional<EmptyCell> empty ();

    public abstract boolean isChip(Chip chip);

    // ------------------------------------------------------------------------
    // BUSINESS LOGIC
    // ------------------------------------------------------------------------

    public boolean isEmpty() { return !isFilled(); }
}
