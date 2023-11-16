package edu.project2;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MazeTest {

    @Test
    void mazeTest1() {
        // given
        Maze maze = new Maze(2, 2);

        // when
        Cell cell = maze.getCell(10, 10);

        // then
        assertThat(cell)
            .isNull();
    }

    @Test
    void mazeTest2() {
        // given
        Maze maze = new Maze(2, 2);

        // when
        Cell cell = maze.getCell(-10, -10);

        // then
        assertThat(cell)
            .isNull();
    }

    @Test
    void mazeTest3() {
        // given
        Maze maze = new Maze(2, 2, null);

        // then
        assertThat(maze)
            .isEqualTo(new Maze(2, 2));
    }

    @Test
    void mazeTest4() {
        // given
        Maze maze1 = new Maze(2, 2, null);
        int row = 2;
        int col = 3;
        Cell[][] grid = new Cell[row][col];
        grid[0][0] = new Cell(true, false);
        grid[0][1] = new Cell();
        grid[0][2] = new Cell(false, true);
        grid[1][0] = new Cell();
        grid[1][1] = new Cell();
        grid[1][2] = new Cell();
        Maze maze2 = new Maze(row, col, grid);

        // then
        assertThat(maze1.equals(maze2))
            .isFalse();
    }

    @Test
    void mazeTest5() {
        // given
        Maze maze1 = new Maze(2, 2);
        Maze maze2 = new Maze(2, 2);

        // then
        assertThat(maze1.equals(maze2))
            .isTrue();
    }
}
