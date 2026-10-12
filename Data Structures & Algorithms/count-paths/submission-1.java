class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }
        return dfs(0, 0, m, n, dp);
    }
    int dfs(int i, int j, int row, int col, int[][] dp) {
        if (i >= row || i < 0 || j >= col || j < 0) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (i == row - 1 && j == col - 1) {
            return 1;
        }
        dp[i][j] = dfs(i + 1, j, row, col, dp) + dfs(i, j + 1, row, col, dp);
        return dp[i][j];
    }
}
