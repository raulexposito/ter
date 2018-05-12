package com.raulexposito.model.board;

import com.raulexposito.model.game.Color;

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
