class Solution {
    public int[] plusOne(int[] digits) {
    int len = digits.length ; 
     for (int i = digits.length - 1; i >= 0; i--) {
    if (digits[i] != 9) {
        digits[i]++;
        return digits;  // Normal case - found a non-9
    }
    digits[i] = 0;  
}
  int[] result = new int[digits.length + 1];
    result[0] = 1;  // First digit is 1, rest are 0 by default
    return result;
      
    }
}