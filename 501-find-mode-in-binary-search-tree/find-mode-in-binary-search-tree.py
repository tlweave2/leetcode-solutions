# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def findMode(self, root: Optional[TreeNode]) -> List[int]:
        freq = Counter()
        
        # Use DFS to traverse entire tree
        def dfs(node):
            if node:
                freq[node.val] += 1
                dfs(node.left)
                dfs(node.right)
        
        dfs(root)
        
        # Find maximum frequency
        max_freq = max(freq.values()) if freq else 0
        
        # Return all values that have the maximum frequency
        return [val for val, count in freq.items() if count == max_freq]