class Solution {
    public int maxSubArray(int[] nums) {
        int ans=0, n=nums.length;
        int maxAns = nums[0];
        for(int i=0;i<n;i++){
            if(ans<0){
                ans=0;
            }
            ans+=nums[i];
            
                maxAns = Math.max(maxAns, ans);
        }
        return maxAns;
    }
}
