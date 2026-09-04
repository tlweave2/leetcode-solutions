class Solution:
    def twoSum(self, numbers: List[int], target: int) -> List[int]:
        res = 0
        right = len(numbers)-1 
        left =0
        while left < right:
            if numbers[left] + numbers[right] == target:
                return [left +1 , right +1]
            if numbers[left] + numbers[right] > target:
                right -= 1
            if numbers[left] + numbers[right] < target:
                left += 1
        return res