package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueensBacktracking {
    public static void main(String[] args) {
        int n = 4;
        NQueensBacktracking solver = new NQueensBacktracking();
        List<List<String>> solutions = solver.solveNQueens(n);
        System.out.println("Total solutions for " + n + "-Queens: " + solutions.size());
        for (List<String> solution : solutions) {
            for (String row : solution) {
                System.out.println(row);
            }
            System.out.println();
        }
    }

    private List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];

        for (char[] row : board) {
            Arrays.fill(row, '.');
        }
        backtrack(0, board, result, n);
        return result;
    }

    private void backtrack(int row, char[][] board, List<List<String>> results, int n) {

        if (row == n) {
            results.add(construct(board));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isSafe(board, row, col, n)) {
                board[row][col] = 'Q';
                backtrack(row + 1, board, results, n);
                board[row][col] = '.';
            }
        }
    }

    private List<String> construct(char[][] board) {
        List<String> config = new ArrayList<>();
        for (char[] row : board)
            config.add(new String(row));
        return config;
    }

    private boolean isSafe(char[][] board, int row, int col, int n) {
        // Check column above the current row
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // Check top-left diagonal
        int i = row - 1;
        int j = col - 1;
        while (i >= 0 && j >= 0) {
            if (board[i][j] == 'Q') {
                return false;
            }
            i--;
            j--;
        }

        // Check top-right diagonal
        i = row - 1;
        j = col + 1;
        while (i >= 0 && j < n) {
            if (board[i][j] == 'Q') {
                return false;
            }
            i--;
            j++;
        }

        // Safe to place queen
        return true;
    }


}


