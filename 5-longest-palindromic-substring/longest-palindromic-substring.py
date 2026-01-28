class Solution:
    def longestPalindrome(self, s: str) -> str:
        if len(s) <= 1:
            return s
        
        def expand_around_center(left: int, right: int) -> int:
            """Expand around center and return length of palindrome"""
            while left >= 0 and right < len(s) and s[left] == s[right]:
                left -= 1
                right += 1
            # Return length of palindrome found
            return right - left - 1
        
        start = 0
        max_len = 0
        
        for i in range(len(s)):
            # Check odd-length palindromes (single character center)
            len1 = expand_around_center(i, i)
            # Check even-length palindromes (two character center)
            len2 = expand_around_center(i, i + 1)
            
            # Get the longer palindrome
            current_len = max(len1, len2)
            
            # Update if we found a longer palindrome
            if current_len > max_len:
                max_len = current_len
                # Calculate start index of the palindrome
                start = i - (current_len - 1) // 2
        
        return s[start:start + max_len]
        