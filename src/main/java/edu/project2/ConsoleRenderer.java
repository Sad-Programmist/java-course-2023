package edu.project2;

import java.util.List;

public class ConsoleRenderer implements Renderer {
    @SuppressWarnings("MultipleStringLiterals")
    @Override
    public String render(Maze maze) {
        StringBuilder builder = new StringBuilder();

        for (int row = 0; row < maze.getHeight(); row++) {
            if (row == 0) {
                for (int col = 0; col < maze.getWidth(); col++) {
                    builder.append("+--");
                }
                builder.append("+");
                builder.append("\n");
            }

            for (int col = 0; col < maze.getWidth(); col++) {
                if (col == 0) {
                    builder.append("|");
                }
                Cell cell = maze.getCell(row, col);
                builder.append("  ");
                if (cell.isHasRightWall()) {
                    builder.append("|");
                } else if (col != maze.getWidth() - 1) {
                    builder.append(" ");
                }
            }
            builder.append("|");
            builder.append("\n");

            if (row != maze.getHeight() - 1) {
                for (int col = 0; col < maze.getWidth(); col++) {
                    if (col == 0) {
                        builder.append("+");
                    }
                    Cell cell = maze.getCell(row, col);
                    if (cell.isHasBottomWall()) {
                        builder.append("--");
                    } else {
                        builder.append("  ");
                    }
                    builder.append("+");
                }
            } else {
                for (int col = 0; col < maze.getWidth(); col++) {
                    builder.append("+--");
                }
                builder.append("+");
            }
            builder.append("\n");
        }

        return builder.toString();
    }

    @SuppressWarnings("MultipleStringLiterals")
    @Override
    public String render(Maze maze, List<Coordinate> path) {
        StringBuilder builder = new StringBuilder();

        for (int row = 0; row < maze.getHeight(); row++) {
            if (row == 0) {
                for (int col = 0; col < maze.getWidth(); col++) {
                    builder.append("+--");
                }
                builder.append("+");
                builder.append("\n");
            }

            for (int col = 0; col < maze.getWidth(); col++) {
                if (col == 0) {
                    builder.append("|");
                }
                Cell cell = maze.getCell(row, col);
                if (path.contains(new Coordinate(row, col))) {
                    builder.append("██");
                } else {
                    builder.append("  ");
                }
                if (cell.isHasRightWall()) {
                    builder.append("|");
                } else if (col != maze.getWidth() - 1) {
                    builder.append(" ");
                }
            }
            builder.append("|");
            builder.append("\n");

            if (row != maze.getHeight() - 1) {
                for (int col = 0; col < maze.getWidth(); col++) {
                    if (col == 0) {
                        builder.append("+");
                    }
                    Cell cell = maze.getCell(row, col);
                    if (cell.isHasBottomWall()) {
                        builder.append("--");
                    } else {
                        builder.append("  ");
                    }
                    builder.append("+");
                }
            } else {
                for (int col = 0; col < maze.getWidth(); col++) {
                    builder.append("+--");
                }
                builder.append("+");
            }
            builder.append("\n");
        }

        return builder.toString();
    }
}
