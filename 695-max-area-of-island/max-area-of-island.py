class Solution:
    def maxAreaOfIsland(self, grid: List[List[int]]) -> int:
        if not grid or not grid[0]:
            return 0
        rows = len(grid)
        cols = len(grid[0])
        max_area = 0

        def dfs(row, col):
            if row < 0 or row >= rows or col < 0 or col >= cols or grid[row][col] == 0:
                return 0  # Changed from 'false' to 0

            grid[row][col] = 0
            area = 1

            area += dfs(row+1, col)
            area += dfs(row-1, col)
            area += dfs(row, col+1)  # Fixed: was row+1, col+1
            area += dfs(row, col-1)  # Fixed: was row+1, col-1
            
            return area
            
        for row in range(rows):
            for col in range(cols):  # Fixed: was 'cols' variable
                if grid[row][col] == 1:  # Fixed: was 'cols' variable
                    current_area = dfs(row, col)  # Fixed: was 'cols' variable
                    max_area = max(max_area, current_area)
        return max_area