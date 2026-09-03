class Solution:
    def trap(self, height: List[int]) -> int:
        if not height : return 0
        right = len(height)-1
        left = 0
        res = 0

        leftmax = height[left]
        rightmax = height[right]
        while left < right:
            if leftmax < rightmax:
                left += 1
                leftmax = max(leftmax, height[left])
                res += leftmax -height[left]
            else:
                right -= 1
                rightmax = max(rightmax , height[right])
                res += rightmax -height[right]
        return res
