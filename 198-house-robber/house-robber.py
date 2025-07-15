class Solution:
    def rob(self, nums: List[int]) -> int:
        if not nums:
            return 0
        if len(nums) == 1:
            return nums[0]
        
        two_houses_back = nums[0]
        one_house_back = max(nums[0], nums[1])
        
        for i in range(2, len(nums)):
            current = max(one_house_back, two_houses_back + nums[i])
            two_houses_back = one_house_back
            one_house_back = current
        
        return one_house_back