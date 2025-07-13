class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        if not nums:  # Handle empty list
            return 0
            
        changetoset = set(nums)  # Convert list to set
        max_len = 1  # Don't use 'len' as variable name
        
        for j in changetoset:
            if j-1 in changetoset:  # Use 'in', not 'is in'
                continue
            
            current_len = 1  # Start counting from current number
            current_num = j
            
            while current_num + 1 in changetoset:  # Check next number
                current_len += 1
                current_num += 1  # Move to next number
            
            max_len = max(max_len, current_len)  # Update maximum
        
        return max_len
