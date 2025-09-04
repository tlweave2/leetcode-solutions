class Solution {
       public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);                 // <-- sort enables two-pointer + easy dedupe
        int n = nums.length;

        for (int i = 0; i < n - 2; i++) {
            // skip duplicate anchors
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            // since array is sorted, if nums[i] > 0, sum can't be 0 anymore
            if (nums[i] > 0) break;

            int l = i + 1, r = n - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));

                    // move both pointers past duplicates
                    int lv = nums[l], rv = nums[r];
                    while (l < r && nums[l] == lv) l++;
                    while (l < r && nums[r] == rv) r--;
                } else if (sum < 0) {
                    l++; // need a larger sum
                } else {
                    r--; // need a smaller sum
                }
            }
        }
        return res;
    }
}