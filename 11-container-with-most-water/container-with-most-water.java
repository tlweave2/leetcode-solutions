class Solution {
    public int maxArea(int[] height) {
        if(height.length < 2)return 0;
        int maxWater =0;
        int left=0;
        int right = height.length-1;
        while(left < right){
            int currentArea = Math.min(height[left], height[right]) * (right - left);
            
            maxWater = Math.max(maxWater, currentArea);
           if(height[left] < height[right]){
            left++;
           }else
           right--;




        }
        return maxWater;
    }
}