class Solution {
    public int missingNumber(int[] nums) {
     int missing = nums.length;  // Start with n
for (int i = 0; i < nums.length; i++) {
    missing ^= i ^ nums[i];  // XOR index with value
}
return missing;
   
    }
}