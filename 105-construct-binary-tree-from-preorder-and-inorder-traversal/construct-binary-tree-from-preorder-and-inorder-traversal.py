# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder, inorder):
        inorder_map = {val: i for i, val in enumerate(inorder)}  # O(1) lookup
        self.preorder_idx = 0  # Track current position in preorder
    
        def build(left, right):  # Build tree for inorder[left:right+1]
           if left > right:
                return None
        
           # Get next root from preorder
           root_val = preorder[self.preorder_idx]
           self.preorder_idx += 1
           root = TreeNode(root_val)
        
           root_idx = inorder_map[root_val]  # O(1) lookup
        
        # Build left first (preorder goes root→left→right)
           root.left = build(left, root_idx - 1)
           root.right = build(root_idx + 1, right)
        
           return root
    
        return build(0, len(inorder) - 1)