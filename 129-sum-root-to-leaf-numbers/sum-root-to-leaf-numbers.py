# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
       
        if not root:
            return 0
        
        def helper(node, current_num):
        
            
            if not node:
                return 0
            
            current_num = current_num * 10 + node.val
  
            # STEP 4: Check if this is a leaf node (no children)
            if not node.left and not node.right:
                # This is a leaf! Return the complete number we built
                return current_num
            
            # STEP 5: Not a leaf, so recursively explore both subtrees
            # Get sum from left subtree + sum from right subtree
            return helper(node.left, current_num) + helper(node.right, current_num)
        
        # STEP 6: Start the recursion with root node and initial number 0
        return helper(root, 0)
