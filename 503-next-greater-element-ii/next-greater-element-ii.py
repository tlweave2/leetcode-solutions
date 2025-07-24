class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        n = len(nums)
        result = [-1] *n
        stack = []

        for i in range(n*2):
            current_num = nums[i % n]
            while stack and nums[stack[-1]] < current_num:
                index = stack.pop()
                result[index] = current_num
            if i< n:
                stack.append(i)
        return result
        