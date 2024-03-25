package code.dsa.backtracking;

public class NKnights {
    static int count = 0;

    public static void main(String[] args) {
        int n = 4;
        boolean[][] board = new boolean[n][n];
        knights(board, 0, 0, 4);
        System.out.println(count);
    }

    private static void knights(boolean[][] board, int row, int col, int knights) {
        if(knights == 0) {
            displayBoard(board);
            return;
        }

        if (row == board.length - 1 && col == board.length) return;

        if (col == board.length) {
            knights(board, row + 1, 0, knights);
            return;
        }

        if(isSafe(board, row, col)) {
            board[row][col] = true;
            knights(board, row, col + 1, knights - 1);
            board[row][col] = false;
        }

        knights(board, row, col + 1, knights);
    }

    private static boolean isSafe(boolean[][] board, int row, int col) {
        if(isCoordinateValid(board, row - 2, col - 1) && board[row - 2][col - 1])
            return false;
        if(isCoordinateValid(board, row - 2, col + 1) && board[row - 2][col + 1])
            return false;
        if(isCoordinateValid(board, row - 1, col + 2) && board[row - 1][col + 2])
            return false;
        if(isCoordinateValid(board, row - 1, col - 2) && board[row - 1][col - 2])
            return false;

        return true;
    }

    private static boolean isCoordinateValid(boolean[][] board, int row, int col) {
        return row >= 0 && row < board.length && col >= 0 && col < board.length;
    }

    private static void displayBoard(boolean[][] board) {
        for(boolean[] row : board) {
            for (boolean cell : row)
                System.out.print(cell ? "K " : "X ");
            System.out.println();
        }
        System.out.println();
        count++;
    }
}
