class Solution {

    boolean[][] rows = new boolean[9][10];
    boolean[][] cols = new boolean[9][10];
    boolean[][] boxes = new boolean[9][10];

    public void solveSudoku(char[][] board) {

        // Step 1: Fill tracking arrays
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int digit = board[i][j] - '0';
                    int box = (i / 3) * 3 + (j / 3);

                    rows[i][digit] = true;
                    cols[j][digit] = true;
                    boxes[box][digit] = true;
                }
            }
        }

        solve(board, 0, 0);
    }

    public boolean solve(char[][] board, int row, int col) {
        if (row == 9) return true;

        int nextRow = row;
        int nextCol = col + 1;

        if (col == 8) {
            nextRow = row + 1;
            nextCol = 0;
        }

        if (board[row][col] != '.') {
            return solve(board, nextRow, nextCol);
        }

        int box = (row / 3) * 3 + (col / 3);

        for (int digit = 1; digit <= 9; digit++) {
            if (!rows[row][digit] && !cols[col][digit] && !boxes[box][digit]) {

                // place
                board[row][col] = (char)(digit + '0');
                rows[row][digit] = true;
                cols[col][digit] = true;
                boxes[box][digit] = true;

                if (solve(board, nextRow, nextCol)) return true;

                // backtrack
                board[row][col] = '.';
                rows[row][digit] = false;
                cols[col][digit] = false;
                boxes[box][digit] = false;
            }
        }

        return false;
    }
}