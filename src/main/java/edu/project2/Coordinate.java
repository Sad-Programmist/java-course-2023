package edu.project2;

public record  Coordinate(int row, int col) {

    @Override public int row() {
        return row;
    }

    @Override public int col() {
        return col;
    }
}
