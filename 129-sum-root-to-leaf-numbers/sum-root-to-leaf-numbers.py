# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        # STEP 1: Handle edge case - empty tree
        if not root:
            return 0
        
        def helper(node, current_num):
            """
            Recursive helper function that:
            1. Builds numbers as we traverse down
            2. Returns sum of all root-to-leaf numbers
            
            Parameters:
            - node: current tree node we're visiting
            - current_num: number built so far on this path
            """
            
            # STEP 2: Base case - if node is None (null), contribute 0 to sum
            if not node:
                return 0
            
            # STEP 3: Build the current number by appending this node's value
            current_num = current_num * 10 + node.val
            # Example: if current_num = 12 and node.val = 3
            # Then: current_num = 12 * 10 + 3 = 123
            
            # STEP 4: Check if this is a leaf node (no children)
            if not node.left and not node.right:
                # This is a leaf! Return the complete number we built
                return current_num
            
            # STEP 5: Not a leaf, so recursively explore both subtrees
            # Get sum from left subtree + sum from right subtree
            return helper(node.left, current_num) + helper(node.right, current_num)
        
        # STEP 6: Start the recursion with root node and initial number 0
        return helper(root, 0)
