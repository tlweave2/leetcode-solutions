class Solution(object):
    def merge(self, nums1, m, nums2, n):
        i = m - 1          # last real element in nums1
        j = n - 1          # last element in nums2
        last = m + n - 1   # last slot in nums1

        while j >= 0:
            if i >= 0 and nums1[i] > nums2[j]:
                nums1[last] = nums1[i]
                i -= 1
            else:
                nums1[last] = nums2[j]
                j -= 1
            last -= 1