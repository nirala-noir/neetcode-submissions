class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        int fromZero = zeroOneKnap(nums, 0, n - 1, dp);
        Arrays.fill(dp, -1);
        int fromFirst = zeroOneKnap(nums, 1, n, dp);
        return Math.max(fromZero, fromFirst);
    }
    int zeroOneKnap(int[] nums, int start, int end, int[] dp) {
        if (start >= end) {
            return 0;
        }
        if (dp[start] != -1) {
            return dp[start];
        }
        dp[start] = Math.max(nums[start] + zeroOneKnap(nums, start + 2, end, dp),
            zeroOneKnap(nums, start + 1, end, dp));
        return dp[start];
    }
}
