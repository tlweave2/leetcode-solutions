class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        for (char[] row : board) Arrays.fill(row, '.');

        boolean[] cols  = new boolean[n];
        boolean[] diag1 = new boolean[2 * n - 1]; // r + c
        boolean[] diag2 = new boolean[2 * n - 1]; // r - c + (n - 1)

        backtrack(0, n, board, cols, diag1, diag2, res);
        return res;
    }

    private void backtrack(int r, int n,
                           char[][] board,
                           boolean[] cols, boolean[] diag1, boolean[] diag2,
                           List<List<String>> res) {
        if (r == n) {
            res.add(toList(board));
            return;
        }

        for (int c = 0; c < n; c++) {
            int d1 = r + c;
            int d2 = r - c + (n - 1);
            if (cols[c] || diag1[d1] || diag2[d2]) continue;

            // place
            board[r][c] = 'Q';
            cols[c] = diag1[d1] = diag2[d2] = true;

            backtrack(r + 1, n, board, cols, diag1, diag2, res);

            // remove
            board[r][c] = '.';
            cols[c] = diag1[d1] = diag2[d2] = false;
        }
    }

    private List<String> toList(char[][] board) {
        List<String> out = new ArrayList<>(board.length);
        for (char[] row : board) out.add(new String(row));
        return out;
    }
}