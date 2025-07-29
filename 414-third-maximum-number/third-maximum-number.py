class Solution:
    def thirdMax(self, nums: List[int]) -> int:
        num = list(set(nums))
        num.sort(reverse = True)
        if len(num) < 3:
            return num[0]
        else:
            return num[2]
       