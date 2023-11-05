package edu.project2;

import java.util.Objects;

public final class Maze {
    private final int height;
    private final int width;
    private final Cell[][] grid;

    public Maze(int height, int width) {
        this.height = height;
        this.width = width;
        this.grid = new Cell[height][width];
    }

    public Maze(int height, int width, Cell[][] grid) {
        this.height = height;
        this.width = width;
        this.grid = Objects.requireNonNullElseGet(grid, () -> new Cell[height][width]);
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public Cell getCell(int row, int col) {
        if (isValidCoordinate(row, col)) {
            return grid[row][col];
        } else {
            return null;
        }
    }

    private boolean isValidCoordinate(int row, int col) {
        return row >= 0 && row < height && col >= 0 && col < width;
    }

    @SuppressWarnings("EqualsHashCode")
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Maze otherMaze = (Maze) obj;

        if (height != otherMaze.height || width != otherMaze.width) {
            return false;
        }

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (grid[i][j] == null && otherMaze.grid[i][j] == null) {
                    return true;
                } else if (grid[i][j] == null || otherMaze.grid[i][j] == null) {
                    return false;
                }
                if (!grid[i][j].equals(otherMaze.grid[i][j])) {
                    return false;
                }
            }
        }

        return true;
    }
}

