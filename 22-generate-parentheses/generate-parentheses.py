class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        result = []
        
        def backtrack(current, open_count, close_count):
            # Base case: we've used all n pairs
            if len(current) == 2 * n:
                result.append(current)
                return
            
            # Add opening parenthesis if we haven't used all n
            if open_count < n:
                backtrack(current + "(", open_count + 1, close_count)
            
            # Add closing parenthesis if it won't violate rules
            if close_count < open_count:
                backtrack(current + ")", open_count, close_count + 1)
        
        backtrack("", 0, 0)
        return result