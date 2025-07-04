class Solution {
   
        public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        // Create memoization array to avoid recalculating same subproblems
        Integer[] memo = new Integer[nums.length];
        
        return robHelper(nums, 0, memo);
    }
    
    // Recursive helper method with memoization
    private int robHelper(int[] nums, int index, Integer[] memo) {
        // Base case: if we've gone past the last house
        if (index >= nums.length) {
            return 0;
        }
        
        // If we've already calculated this subproblem, return cached result
        if (memo[index] != null) {
            return memo[index];
        }
        
        // Two choices at each house:
        // Option 1: Rob this house + best from house (index + 2) onwards
        int robCurrent = nums[index] + robHelper(nums, index + 2, memo);
        
        // Option 2: Skip this house + best from house (index + 1) onwards  
        int skipCurrent = robHelper(nums, index + 1, memo);
        
        // Take the maximum of the two options
        memo[index] = Math.max(robCurrent, skipCurrent);
        
        return memo[index];
    }
    }
