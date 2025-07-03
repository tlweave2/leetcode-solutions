class Solution {
    public int threeSumClosest(int[] nums, int target) {
    Arrays.sort(nums);
        int closestSum = nums[0] + nums[1] + nums[2];
        
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            
            while (left < right) {
                int currentSum = nums[i] + nums[left] + nums[right];
                
                // If current sum is closer to target, update closestSum
                if (Math.abs(currentSum - target) < Math.abs(closestSum - target)) {
                    closestSum = currentSum;
                }
                
                // If we found exact target, return immediately
                if (currentSum == target) {
                    return currentSum;
                }
                // If sum is less than target, we need larger sum
                else if (currentSum < target) {
                    left++;
                }
                // If sum is greater than target, we need smaller sum
                else {
                    right--;
                }
            }
        }
        
        return closestSum;
    }
}