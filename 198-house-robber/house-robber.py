class Solution:
    def rob(self, nums: List[int]) -> int:
        if not nums:
            return 0
        if len(nums) == 1:
            return nums[0]
        
        # Create DP array
        dp = [0] * len(nums)
        
        # Base cases
        dp[0] = nums[0]                    # First house: just rob it
        dp[1] = max(nums[0], nums[1])      # Second house: rob the better one
        
        # Fill the rest starting from index 2
        for i in range(2, len(nums)):
            dp[i] = max(dp[i-1], dp[i-2] + nums[i])
        
        return dp[-1]  # Last element has the answer