package edu.hw1;

public class Task8 {

    private Task8() {
    }

    @SuppressWarnings("MagicNumber")
    private static boolean knightBoardCapture(int[][] board) {
        if (board[0].length != Constants.BOARD_SIZE && board.length != Constants.BOARD_SIZE) {
            return false;
        }
        int[] rowMovements = {-1, -2, -2, -1, 1, 2, 2, 1};
        int[] columnMovements = {-2, -1, 1, 2, 2, 1, -1, -2};
        for (int rowNumber = 0; rowNumber < board.length; rowNumber++) {
            for (int columnNumber = 0; columnNumber < board[0].length; columnNumber++) {
                if (board[rowNumber][columnNumber] == 1) {
                    for (int moveNumber = 0; moveNumber < rowMovements.length; moveNumber++) {
                        if (rowNumber + rowMovements[moveNumber] < board[0].length
                            && rowNumber + rowMovements[moveNumber] >= 0
                            && columnNumber + columnMovements[moveNumber] < board.length
                            && columnNumber + columnMovements[moveNumber] >= 0) {
                            if (board[rowNumber + rowMovements[moveNumber]][columnNumber
                                + columnMovements[moveNumber]] == 1) {
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

    public static boolean runTask8(int[][] board) {
        return knightBoardCapture(board);
    }

}
