class Solution {
    public int[] productExceptSelf(int[] nums) {
 int[] result = new int[nums.length];

// Fill result with products of all elements to the LEFT of each position
result[0] = 1;  // Nothing to the left of index 0
for (int i = 1; i < nums.length; i++) {
    result[i] = result[i-1] * nums[i-1];  // Previous result * element to the left
}
    int rightProduct = 1;  // Track running product from the right
for (int i = nums.length - 1; i >= 0; i--) {
    result[i] = result[i] * rightProduct;  // Multiply existing left product by right product
    rightProduct = rightProduct * nums[i]; // Update right product for next iteration
}return result;
}
}