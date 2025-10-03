class Solution {
        static class Cell {
        int row, col, height;
        
        Cell(int row, int col, int height) {
            this.row = row;
            this.col = col;
            this.height = height;
        }
    }
    public int trapRainWater(int[][] heightMap) {
        if(heightMap == null  || heightMap.length == 0){
            return 0;
        }
        int m = heightMap.length;
        int n = heightMap[0].length;
   PriorityQueue<Cell> pq = new PriorityQueue<>((a, b) -> a.height - b.height);
        
        // Track visited cells
        boolean[][] visited = new boolean[m][n];
        
        // Step 1: Add all border cells to the priority queue
        // Top and bottom borders
        for (int col = 0; col < n; col++) {
            pq.offer(new Cell(0, col, heightMap[0][col]));
            pq.offer(new Cell(m - 1, col, heightMap[m - 1][col]));
            visited[0][col] = true;
            visited[m - 1][col] = true;
        }
        
        // Left and right borders
        for (int row = 1; row < m - 1; row++) {
            pq.offer(new Cell(row, 0, heightMap[row][0]));
            pq.offer(new Cell(row, n - 1, heightMap[row][n - 1]));
            visited[row][0] = true;
            visited[row][n - 1] = true;
        }
        
        // Directions: up, down, left, right
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        int waterTrapped = 0;
        int maxHeight = 0; // Current water level
        
        // Step 2: Process cells from outside to inside
        while (!pq.isEmpty()) {
            Cell current = pq.poll();
            
            // Update the water level (it can only increase)
            maxHeight = Math.max(maxHeight, current.height);
            
            // Step 3: Check all 4 neighbors
            for (int[] dir : directions) {
                int newRow = current.row + dir[0];
                int newCol = current.col + dir[1];
                
                // Check bounds and if already visited
                if (newRow < 0 || newRow >= m || newCol < 0 || newCol >= n || visited[newRow][newCol]) {
                    continue;
                }
                
                // Mark as visited
                visited[newRow][newCol] = true;
                
                // Calculate trapped water at this cell
                int cellHeight = heightMap[newRow][newCol];
                if (cellHeight < maxHeight) {
                    waterTrapped += maxHeight - cellHeight;
                }
                
                // Add this cell to the priority queue
                pq.offer(new Cell(newRow, newCol, cellHeight));
            }
        }
        
        return waterTrapped;
    }
}