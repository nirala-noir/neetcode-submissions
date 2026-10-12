class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return calculate(0, 0, n, m, text1, text2, dp);
    }
    int calculate(int i, int j, int n, int m, String str1, String str2, int[][] dp) {
        if (i >= n || i < 0 || j >= m || j < 0) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (str1.charAt(i) == str2.charAt(j)) {
            dp[i][j] = 1 + calculate(i + 1, j + 1, n, m, str1, str2, dp);
            return dp[i][j];
        }
        dp[i][j] = Math.max(
            calculate(i + 1, j, n, m, str1, str2, dp), calculate(i, j + 1, n, m, str1, str2, dp));
        return dp[i][j];
    }
}
