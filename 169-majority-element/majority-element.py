class Solution(object):
    def majorityElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        count = {}
        res, maxi = 0,0
        for n in nums:
            count[n] = 1 + count.get(n,0)
            res = n if count[n] > maxi else res
            maxi = max(count[n], maxi)

        return res
