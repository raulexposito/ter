package com.raulexposito.model.board;

public enum Color {
    BLACK,
    WHITE;

    private Color opposite;
    private String text;

    static {
        BLACK.opposite = WHITE;
        WHITE.opposite = BLACK;
        BLACK.text = "B";
        WHITE.text = "W";
    }

    public Color getOpposite() {
        return opposite;
    }

    @Override
    public String toString() {
        return text + " ";
    }
}
