class Solution:
    def maxAreaOfIsland(self, grid: list[list[int]]) -> int:
        if not grid or not grid[0]:
            return 0
        
        rows, cols = len(grid), len(grid[0])
        max_area = 0
        
        def dfs(row, col):
            # Boundary checks and water check
            if (row < 0 or row >= rows or 
                col < 0 or col >= cols or 
                grid[row][col] == 0):
                return 0
            
            # Mark as visited and count this cell
            grid[row][col] = 0
            area = 1
            
            # Add area from all 4 directions
            area += dfs(row + 1, col)  # down
            area += dfs(row - 1, col)  # up
            area += dfs(row, col + 1)  # right
            area += dfs(row, col - 1)  # left
            
            return area
        
        # Check every cell
        for row in range(rows):
            for col in range(cols):
                if grid[row][col] == 1:  # Found land
                    current_area = dfs(row, col)
                    max_area = max(max_area, current_area)
        
        return max_area