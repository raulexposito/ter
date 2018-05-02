package com.raulexposito.model.cell;

import com.raulexposito.model.Color;

public abstract class Cell {

	// ------------------------------------------------------------------------
	// ABSTRACT METHODS
	// ------------------------------------------------------------------------

	public abstract boolean isFilled();

	public abstract boolean hasColor(Color color);

	// ------------------------------------------------------------------------
	// BUSINESS LOGIC
	// ------------------------------------------------------------------------

	public boolean isEmpty() {
		return !isFilled();
	}
}
