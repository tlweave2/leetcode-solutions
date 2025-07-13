class Solution:
    def partition(self, s: str) -> List[List[str]]:
      
        result = []
        current_partition = []
        
        def is_palindrome(substring):
           
            return substring == substring[::-1]
        
        def backtrack(start_index):
         
            # Base case: reached end of string
            if start_index == len(s):
                # Found a complete valid partition!
                result.append(current_partition[:])  # Make a copy!
                return
            
            # Try all possible cuts from current position
            for end_index in range(start_index, len(s)):
                # Extract substring from start_index to end_index (inclusive)
                substring = s[start_index:end_index + 1]
                
                # Check if this substring is a palindrome
                if is_palindrome(substring):
                    # CHOOSE: Add to current partition
                    current_partition.append(substring)
                    
                    # EXPLORE: Recursively partition the rest
                    backtrack(end_index + 1)
                    
                    # UNCHOOSE: Remove for backtracking (try other options)
                    current_partition.pop()
        
        # Start backtracking from index 0
        backtrack(0)
        return result
        