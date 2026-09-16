class Solution:
    def minSubArrayLen(self, target: int, nums: list[int]) -> int:
        res = float("inf")
        l, total = 0 , 0


        for r in range(len(nums)):
            total += nums[r]
            while total >= target:
                res = min(r- l +1, res)
                total -= nums[l]
                l+=1




        return 0 if res == float("inf") else res