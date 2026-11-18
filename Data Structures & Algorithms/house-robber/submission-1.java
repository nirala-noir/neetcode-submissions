class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        int fromZero = zeroOneKnap(nums, 0, dp);
        int fromFirst = zeroOneKnap(nums, 1, dp);
        return Math.max(fromZero, fromFirst);
    }
    int zeroOneKnap(int[] nums, int start, int[] dp) {
        if (start >= nums.length) {
            return 0;
        }
        if (dp[start] != -1) {
            return dp[start];
        }
        dp[start] = Math.max(
            nums[start] + zeroOneKnap(nums, start + 2, dp), zeroOneKnap(nums, start + 1, dp));
        return dp[start];
    }
}
