package edu.project2;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class EllerMazeGeneratorTest {

    @Test
    void ellerMazeGeneratorTest1() {
        // given
        EllerMazeGenerator ellerMazeGenerator = new EllerMazeGenerator();

        // when
        Maze maze = ellerMazeGenerator.generate(-10, -10);

        // then
        assertThat(maze)
            .isNull();
    }

    @Test
    void ellerMazeGeneratorTest2() {
        // given
        EllerMazeGenerator ellerMazeGenerator = new EllerMazeGenerator();

        // when
        Maze maze = ellerMazeGenerator.generate(0, 0);

        // then
        assertThat(maze)
            .isEqualTo(new Maze(0, 0));
    }
}
