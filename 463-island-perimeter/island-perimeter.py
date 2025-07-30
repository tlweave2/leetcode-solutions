class Solution:
    def islandPerimeter(self, grid: List[List[int]]) -> int:
        sides = 0
        rows, cols = len(grid), len(grid[0])
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] ==1:

                    if grid[i][j] == 1:

                        # Check all 4 directions
                        # Top
                        if i == 0 or grid[i-1][j] == 0:
                            sides += 1
                        # Bottom  
                        if i == rows-1 or grid[i+1][j] == 0:
                            sides += 1
                        # Left
                        if j == 0 or grid[i][j-1] == 0:
                            sides += 1
                        # Right
                        if j == cols-1 or grid[i][j+1] == 0:
                            sides += 1
        
        return sides