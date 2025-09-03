class Solution {
  public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;

        // 1) Detect if first row / first column need zeroing
        boolean zeroFirstRow = false, zeroFirstCol = false;

        // Check first row
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) { zeroFirstRow = true; break; }
        }
        // Check first column
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) { zeroFirstCol = true; break; }
        }

        // 2) Use first row/col as markers for the rest of the matrix
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0; // mark row i
                    matrix[0][j] = 0; // mark col j
                }
            }
        }

        // 3) Zero cells based on markers
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // 4) Zero first row/column last (if needed)
        if (zeroFirstRow) {
            for (int j = 0; j < n; j++) matrix[0][j] = 0;
        }
        if (zeroFirstCol) {
            for (int i = 0; i < m; i++) matrix[i][0] = 0;
        }
    }
}