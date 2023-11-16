package edu.project2;

import java.util.Random;

public class EllerMazeGenerator implements Generator {
    private final Random random;

    public EllerMazeGenerator() {
        this.random = new Random();
    }

    @SuppressWarnings("CyclomaticComplexity")
    @Override
    public Maze generate(int height, int width) {
        if (height < 0 || width < 0) {
            return null;
        }
        Cell[][] grid = initializeGrid(height, width);
        int id = 1;
        int[] set = new int[width];

        for (int i = 0; i < width; i++) {
            set[i] = id;
            id++;
        }

        boolean[] bol = new boolean[2 * (width * (height - 1) + height * (width - 1))];
        for (int i = 0; i < bol.length; i++) {
            bol[i] = random.nextBoolean();
        }

        int bolIndex = 0;

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width - 1; col++) {
                if (bol[bolIndex]) {
                    grid[row][col].setHasRightWall(true);
                } else {
                    if (set[col] == set[col + 1]) {
                        grid[row][col].setHasRightWall(true);
                    } else {
                        for (int i = 0; i < width; i++) {
                            if (set[i] == set[col + 1]) {
                                set[i] = set[col];
                            }
                        }
                    }
                }
                bolIndex++;
            }

            for (int col = 0; col < width; col++) {
                int free = 0;
                if (bol[bolIndex]) {
                    for (int i = 0; i < width; i++) {
                        if (set[i] == set[col] && !grid[row][i].isHasBottomWall()) {
                            free++;
                        }
                    }
                    if (free > 1) {
                        grid[row][col].setHasBottomWall(true);
                    }
                }
                bolIndex++;
            }

            for (int i = 0; i < width; i++) {
                if (grid[row][i].isHasBottomWall()) {
                    set[i] = id;
                    id++;
                }
            }

            if (row == height - 1) {
                for (int col = 0; col < width - 1; col++) {
                    if (set[col] != set[col + 1]) {
                        grid[row][col].setHasRightWall(false);
                    }
                }
            }
        }

        return new Maze(height, width, grid);
    }

    private Cell[][] initializeGrid(int height, int width) {
        Cell[][] result = new Cell[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                result[i][j] = new Cell();
            }
        }
        return result;
    }
}
