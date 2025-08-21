class Solution:
    def longestPalindrome(self, s: str) -> int:
        freq = Counter(s)
        count = 0
        odd = False
        for c in freq.values():
            count +=(c // 2) * 2
            if c%2 ==1:
                odd = True
        return count + (1 if odd else 0)
