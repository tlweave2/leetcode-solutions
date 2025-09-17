class Solution {
    public int subarraySum(int[] nums, int k) {
     Map<Integer, Integer> seen = new HashMap<>();
        seen.put(0, 1); // empty-prefix sum

        int prefix = 0, ans = 0;
        for (int x : nums) {
            prefix += x;
            ans += seen.getOrDefault(prefix - k, 0);
            seen.put(prefix, seen.getOrDefault(prefix, 0) + 1);
        }
        return ans;
    }
}