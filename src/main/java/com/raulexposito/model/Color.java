package com.raulexposito.model;

public enum Color {
    BLACK,
    WHITE;

    private Color opposite;

    static {
        BLACK.opposite = WHITE;
        WHITE.opposite = BLACK;
    }

    public Color getOpposite() {
        return opposite;
    }
}
