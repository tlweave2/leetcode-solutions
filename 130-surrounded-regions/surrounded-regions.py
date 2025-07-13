class Solution:
    def solve(self, board: List[List[str]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        """
        Approach: Mark all 'O's connected to border as "safe", then flip the rest
        
        Algorithm:
        1. Find all 'O's on the border
        2. DFS from each border 'O' to mark all connected 'O's as safe
        3. Convert all unmarked 'O's to 'X' (these are surrounded)
        4. Convert all safe 'O's back to 'O'
        """
        if not board or not board[0]:
            return
        
        rows, cols = len(board), len(board[0])
        
        def dfs(r, c):
            """
            DFS to mark all 'O's connected to border as safe ('S')
            """
            # Check bounds and if cell is 'O'
            if (r < 0 or r >= rows or c < 0 or c >= cols or 
                board[r][c] != 'O'):
                return
            
            # Mark as safe (connected to border)
            board[r][c] = 'S'  # S = Safe
            
            # Explore all 4 directions
            dfs(r + 1, c)  # Down
            dfs(r - 1, c)  # Up  
            dfs(r, c + 1)  # Right
            dfs(r, c - 1)  # Left
        
        # Step 1: Mark all border-connected 'O's as safe
        
        # Check first and last rows (top and bottom borders)
        for c in range(cols):
            if board[0][c] == 'O':        # Top border
                dfs(0, c)
            if board[rows-1][c] == 'O':   # Bottom border
                dfs(rows-1, c)
        
        # Check first and last columns (left and right borders)  
        for r in range(rows):
            if board[r][0] == 'O':        # Left border
                dfs(r, 0)
            if board[r][cols-1] == 'O':   # Right border
                dfs(r, cols-1)
        
        # Step 2: Process the entire board
        for r in range(rows):
            for c in range(cols):
                if board[r][c] == 'O':    # Unmarked 'O' = surrounded
                    board[r][c] = 'X'     # Capture it
                elif board[r][c] == 'S':  # Safe 'O' connected to border
                    board[r][c] = 'O'     # Restore it
