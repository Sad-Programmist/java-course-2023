package edu.project2;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ConsoleRenderTest {

    @Test
    void consoleRendererTest1() {
        // given
        ConsoleRenderer consoleRenderer = new ConsoleRenderer();
        int row = 2;
        int col = 3;
        Cell[][] grid = new Cell[row][col];
        grid[0][0] = new Cell(true, false);
        grid[0][1] = new Cell();
        grid[0][2] = new Cell(false, true);
        grid[1][0] = new Cell();
        grid[1][1] = new Cell();
        grid[1][2] = new Cell();
        Maze maze = new Maze(row, col, grid);

        // when
        String renderedMaze = consoleRenderer.render(maze);

        // then
        String expected = "+--+--+--+\n" +
                          "|  |     |\n" +
                          "+  +  +--+\n" +
                          "|        |\n" +
                          "+--+--+--+\n";

        assertThat(renderedMaze)
            .isEqualTo(expected);
    }

    @Test
    void consoleRendererTest2() {
        // given
        ConsoleRenderer consoleRenderer = new ConsoleRenderer();
        int row = 2;
        int col = 3;
        Cell[][] grid = new Cell[row][col];
        grid[0][0] = new Cell(true, false);
        grid[0][1] = new Cell();
        grid[0][2] = new Cell(false, true);
        grid[1][0] = new Cell();
        grid[1][1] = new Cell();
        grid[1][2] = new Cell();
        Maze maze = new Maze(row, col, grid);

        List<Coordinate> path = List.of(new Coordinate(0, 0), new Coordinate(1, 0),
            new Coordinate(1, 1), new Coordinate(0, 1), new Coordinate(0, 2));

        // when
        String renderedMaze = consoleRenderer.render(maze, path);

        // then
        String expected = "+--+--+--+\n" +
                          "|██|██ ██|\n" +
                          "+  +  +--+\n" +
                          "|██ ██   |\n" +
                          "+--+--+--+\n";

        assertThat(renderedMaze)
            .isEqualTo(expected);
    }

    @Test
    void consoleRendererTest3() {
        // given
        ConsoleRenderer consoleRenderer = new ConsoleRenderer();
        int row = 2;
        int col = 3;
        Cell[][] grid = new Cell[row][col];
        grid[0][0] = new Cell(true, false);
        grid[0][1] = new Cell(true, false);
        grid[0][2] = new Cell();
        grid[1][0] = new Cell();
        grid[1][1] = new Cell();
        grid[1][2] = new Cell();
        Maze maze = new Maze(row, col, grid);

        // when
        String renderedMaze = consoleRenderer.render(maze);

        // then
        String expected = "+--+--+--+\n" +
            "|  |  |  |\n" +
            "+  +  +  +\n" +
            "|        |\n" +
            "+--+--+--+\n";

        assertThat(renderedMaze)
            .isEqualTo(expected);
    }
}
