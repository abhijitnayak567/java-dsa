package code.dsa.backtracking;

// https://leetcode.com/problems/sudoku-solver/description/
public class SudokuSolver {

    public static void main(String[] args) {
        int[][] board = {
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };
        System.out.println(solveSudoku(board));
        for (int[] row : board) {
            for (int col : row)
                System.out.print(col + " ");
            System.out.println();
        }

        char[][] board2 = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.' },
                {'6', '.', '.', '1', '9', '5', '.', '.', '.' },
                {'.', '9', '8', '.', '.', '.', '.', '6', '.' },
                {'8', '.', '.', '.', '6', '.', '.', '.', '3' },
                {'4', '.', '.', '8', '.', '3', '.', '.', '1' },
                {'7', '.', '.', '.', '2', '.', '.', '.', '6' },
                {'.', '6', '.', '.', '.', '.', '2', '8', '.' },
                {'.', '.', '.', '4', '1', '9', '.', '.', '5' },
                {'.', '.', '.', '.', '8', '.', '.', '7', '9' }
        };
        solveSudoku(board2);
        for (char[] row : board2) {
            for (char col : row)
                System.out.print(col + " ");
            System.out.println();
        }
    }


    private static void solveSudoku(char[][] board) {
        System.out.println(solve(board));
    }

    private static boolean solveSudoku(int[][] board) {
        int n = board.length;
        int row = -1;
        int col = -1;

        boolean emptyRemaining = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 0) {
                    row = i;
                    col = j;
                    emptyRemaining = true;
                    break;
                }
            }
            if (emptyRemaining) break;
        }
        // no empty means sudoku is solved
        if (!emptyRemaining) return true;

        for (int num = 1; num <= 9; num++) {
            if (isSafe(board, row, col, num)) {
                board[row][col] = num;
                if (solveSudoku(board)) return true;
                else board[row][col] = 0;
            }
        }

        return false;
    }

    private static boolean solve(char[][] board) {
        int n = board.length;
        int row = -1;
        int col = -1;

        boolean emptyRemaining = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '.') {
                    row = i;
                    col = j;
                    emptyRemaining = true;
                    break;
                }
            }
            if (emptyRemaining) break;
        }
        // no empty means sudoku is solved
        if (!emptyRemaining) return true;

        for (char num = '1'; num <= '9'; num++) {
            if (isSafe(board, row, col, num)) {
                board[row][col] = num;
                if (solve(board)) return true;
                else board[row][col] = '.';
            }
        }

        return false;
    }

    private static boolean isSafe(int[][] board, int row, int col, int num) {
        // check row & col
        for (int i = 0; i < board.length; i++)
            if (board[row][i] == num || board[i][col] == num) return false;

        // check in the block
        int sqrt = (int) Math.sqrt(board.length);
        int startRow = row - row % sqrt;
        int startCol = col - col % sqrt;

        for (int i = startRow; i < startRow + sqrt; i++)
            for (int j = startCol; j < startCol + sqrt; j++)
                if (board[i][j] == num) return false;

        return true;
    }

    private static boolean isSafe(char[][] board, int row, int col, char num) {
        // check row & col
        for (int i = 0; i < board.length; i++)
            if (board[row][i] == num || board[i][col] == num) return false;

        // check in the block
        int sqrt = (int) Math.sqrt(board.length);
        int startRow = row - row % sqrt;
        int startCol = col - col % sqrt;

        for (int i = startRow; i < startRow + sqrt; i++)
            for (int j = startCol; j < startCol + sqrt; j++)
                if (board[i][j] == num) return false;

        return true;
    }
}
