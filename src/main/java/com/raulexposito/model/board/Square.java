package com.raulexposito.model.board;

import com.raulexposito.model.Color;

public interface Square {

	// ------------------------------------------------------------------------
	// ABSTRACT METHODS
	// ------------------------------------------------------------------------

	boolean isFilled();

	boolean hasColor(Color color);

	// ------------------------------------------------------------------------
	// BUSINESS LOGIC
	// ------------------------------------------------------------------------

	default boolean isEmpty() {
		return !isFilled();
	}
}
