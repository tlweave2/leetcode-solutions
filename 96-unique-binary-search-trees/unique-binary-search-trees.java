class Solution {
     public int numTrees(int n) {
        long[] dp = new long[n + 1];
        dp[0] = 1; // empty tree
        dp[1] = 1;

        for (int nodes = 2; nodes <= n; nodes++) {
            long total = 0;
            for (int root = 1; root <= nodes; root++) {
                total += dp[root - 1] * dp[nodes - root];
            }
            dp[nodes] = total;
        }

        return (int) dp[n];
    }
}