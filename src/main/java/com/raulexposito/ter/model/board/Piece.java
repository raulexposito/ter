package com.raulexposito.ter.model.board;

public enum Piece {
    CROSS {
        @Override
        public Piece getOpposite() {
            return CIRCLE;
        }

        @Override
        public String toString() {
            return "X";
        }
    },
    CIRCLE {
        @Override
        public Piece getOpposite() {
            return CROSS;
        }

        @Override
        public String toString() {
            return "O";
        }
    };

    public abstract Piece getOpposite();
}
