class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
          List<Integer> result = new ArrayList<>();
        
        if (matrix == null || matrix.length == 0) {
            return result;
        }
        
        // Define boundaries
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        
        while (top <= bottom && left <= right) {
            // 1. Go RIGHT across top row
            for (int col = left; col <= right; col++) {
                result.add(matrix[top][col]);
            }
            top++;  // Top row is done, move boundary down
            
            // 2. Go DOWN right column
            for (int row = top; row <= bottom; row++) {
                result.add(matrix[row][right]);
            }
            right--;  // Right column is done, move boundary left
            
            // 3. Go LEFT across bottom row (if we still have rows)
            if (top <= bottom) {
                for (int col = right; col >= left; col--) {
                    result.add(matrix[bottom][col]);
                }
                bottom--;  // Bottom row is done, move boundary up
            }
            
            // 4. Go UP left column (if we still have columns)
            if (left <= right) {
                for (int row = bottom; row >= top; row--) {
                    result.add(matrix[row][left]);
                }
                left++;  // Left column is done, move boundary right
            }
        }
        
        return result;
    }
}