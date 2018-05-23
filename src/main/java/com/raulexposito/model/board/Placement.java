package com.raulexposito.model.board;

public enum Placement {
    TOP_LEFT("TL"),
    TOP_CENTER("TC"),
    TOP_RIGHT("TR"),
    MIDDLE_LEFT("ML"),
    CENTER("CE"),
    MIDDLE_RIGHT("MR"),
    BOTTOM_LEFT("BL"),
    BOTTOM_CENTER("BC"),
    BOTTOM_RIGHT("BR");

    private final String acronym;

    Placement(String acronym) {
        this.acronym = acronym;
    }

    @Override
    public String toString() {
        return acronym;
    }
}
