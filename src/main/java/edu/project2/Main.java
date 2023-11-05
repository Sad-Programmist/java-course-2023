package edu.project2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private final static Logger LOGGER = LogManager.getLogger();

    private Main() {
    }

    @SuppressWarnings("MagicNumber")
    public static void main(String[] args) {
        EllerMazeGenerator ellerMazeGenerator = new EllerMazeGenerator();
        Maze maze = ellerMazeGenerator.generate(4, 4);

        ConsoleRenderer consoleRenderer = new ConsoleRenderer();
        LOGGER.info("\n" + consoleRenderer.render(maze));
    }
}
