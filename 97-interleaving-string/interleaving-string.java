class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
      int n = s1.length(), m = s2.length();
        if (n + m != s3.length()) return false;

        boolean[] dp = new boolean[m + 1];
        dp[0] = true;

        // i = 0 row: using only s2 to match s3
        for (int j = 1; j <= m; j++) {
            dp[j] = dp[j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
        }

        for (int i = 1; i <= n; i++) {
            // j = 0 col: using only s1 to match s3
            dp[0] = dp[0] && s1.charAt(i - 1) == s3.charAt(i - 1);

            for (int j = 1; j <= m; j++) {
                char c3 = s3.charAt(i + j - 1);
                boolean takeS1 = dp[j] && s1.charAt(i - 1) == c3;     // dp[j] was dp[i-1][j]
                boolean takeS2 = dp[j - 1] && s2.charAt(j - 1) == c3; // dp[j-1] is dp[i][j-1]
                dp[j] = takeS1 || takeS2;
            }
        }

        return dp[m];
    }
}