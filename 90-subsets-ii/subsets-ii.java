class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        
 List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // Sort to handle duplicates
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }
    
    private void backtrack(List<List<Integer>> result, List<Integer> current, 
                          int[] nums, int start) {
        // Add current subset to result
        result.add(new ArrayList<>(current));
        
        // Try adding each remaining element
        for (int i = start; i < nums.length; i++) {
            // Skip duplicates at the same recursion level
            // If i > start, we're at the same level and can skip duplicates
            if (i > start && nums[i] == nums[i-1]) {
                continue;
            }
            
            // Include nums[i]
            current.add(nums[i]);
            
            // Recurse with next index
            backtrack(result, current, nums, i + 1);
            
            // Backtrack - remove last element
            current.remove(current.size() - 1);
        }
    }
}