class Solution {
    public boolean canJump(int[] nums) {
 int maxReach = 0;
for (int i = 0; i < nums.length; i++) {
    // If current position is beyond what we can reach, we're stuck
    if (i > maxReach) return false;
    
    // Update the furthest we can reach from current position
    maxReach = Math.max(maxReach, i + nums[i]);
}
return true;
    }}