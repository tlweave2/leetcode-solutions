
class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows  = new boolean[9][9];
        boolean[][] cols  = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char ch = board[r][c];
                if (ch == '.') continue;                 // ignore empty

              
                int d = ch - '1';                        // 0..8 for digits 1..9
                int b = (r / 3) * 3 + (c / 3);           // 0..8 sub-box id

                if (rows[r][d] || cols[c][d] || boxes[b][d]) return false;

                rows[r][d] = cols[c][d] = boxes[b][d] = true;
            }
        }
        return true;
    }
}