class Solution {
  public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean[] rowZero = new boolean[m];
        boolean[] colZero = new boolean[n];

        // Pass 1: mark rows and columns that need zeroing
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    rowZero[i] = true;
                    colZero[j] = true;
                }
            }
        }

        // Pass 2: write zeros based on marks
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rowZero[i] || colZero[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}