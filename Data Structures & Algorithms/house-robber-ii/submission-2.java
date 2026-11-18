class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        //compare array values when skipping first elem and skipping last elem
        return Math.max(helper(Arrays.copyOfRange(nums, 1, nums.length)), helper(Arrays.copyOfRange(nums, 0, nums.length - 1)));
    }

    private int helper(int[] nums){
        if(nums.length == 0){
            return 0;
        } else if(nums.length == 1){
            return nums[0];
        }

        int[] rob = new int[nums.length];

        rob[0] = nums[0];
        rob[1] = Math.max(rob[0], nums[1]);

        for(int i = 2; i < nums.length; i++){
            rob[i] = Math.max(rob[i - 1], nums[i] + rob[i - 2]);
        }

        return rob[nums.length - 1];
    }
}
