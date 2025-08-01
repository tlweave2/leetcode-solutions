class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if grid is None:
            return 0
        islands = 0
        def dfs(r,c):
            if r < 0 or c < 0 or r >= len(grid) or c >= len(grid[0]) or grid[r][c]=='0':
                return
            grid[r][c] = '0'
            dfs(r + 1, c)  # down
            dfs(r - 1, c)  # up  
            dfs(r, c + 1)  # right
            dfs(r, c - 1)  # left    

        for r in range(len(grid)):
            for c in range(len(grid[0])):
                if grid[r][c] == '1':
                    islands += 1
                    dfs(r,c)
        return islands
