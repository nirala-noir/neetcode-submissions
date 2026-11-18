class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();

        List<Integer> temp = new ArrayList<>();

        checkCombination(nums, 0, target, ans, temp);
        return ans;
    }
    void checkCombination(
        int[] nums, int start, int target, List<List<Integer>> ans, List<Integer> temp) {
        if (target == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        if (start >= nums.length) {
            return;
        }
        if (target >= nums[start]) {
            temp.add(nums[start]);
            checkCombination(nums, start, target - nums[start], ans, temp);
            temp.remove(temp.size() - 1);
        }
        checkCombination(nums, start + 1, target, ans, temp);
    }
}
