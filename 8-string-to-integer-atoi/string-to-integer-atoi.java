class Solution {
    public int myAtoi(String s) {
         if (s == null || s.length() == 0) {
            return 0;
        }
        
        int index = 0;
        int n = s.length();
        
        // Step 1: Skip leading whitespace
        while (index < n && s.charAt(index) == ' ') {
            index++;
        }
        
        // Check if we've reached the end
        if (index == n) {
            return 0;
        }
        
        // Step 2: Determine sign
        boolean isNegative = false;
        if (s.charAt(index) == '-') {
            isNegative = true;
            index++;
        } else if (s.charAt(index) == '+') {
            index++;
        }
        
        // Step 3: Convert digits
        long result = 0; // Use long to detect overflow
        
        while (index < n && Character.isDigit(s.charAt(index))) {
            int digit = s.charAt(index) - '0';
            
            // Check for overflow before adding the digit
            if (result > (Integer.MAX_VALUE - digit) / 10) {
                return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            
            result = result * 10 + digit;
            index++;
        }
        
        // Apply sign
        result = isNegative ? -result : result;
        
        // Step 4: Clamp to 32-bit range (redundant due to overflow check above, but for clarity)
        if (result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (result < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        
        return (int) result;
    }
}