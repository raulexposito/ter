package com.raulexposito.model.board;

public interface Content {

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
