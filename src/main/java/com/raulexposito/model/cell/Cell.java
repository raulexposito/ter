package com.raulexposito.model.cell;

public abstract class Cell {

	// ------------------------------------------------------------------------
	// ABSTRACT METHODS
	// ------------------------------------------------------------------------

	public abstract boolean isFilled();

	public abstract boolean isChip(Chip chip);

	// ------------------------------------------------------------------------
	// BUSINESS LOGIC
	// ------------------------------------------------------------------------

	public boolean isEmpty() {
		return !isFilled();
	}
}
