class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        missing = set(nums)
        missed = []
        for i in range(1,len(nums) +1):
            if i not in missing:
                missed.append(i)
             
        return missed
            


        