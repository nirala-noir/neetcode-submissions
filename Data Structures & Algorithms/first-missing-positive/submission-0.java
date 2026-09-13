class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        int i=0;
        int j=1;
        int[] ans = new int[100001];
        Arrays.fill(ans,0);
        while(i<n){
            if(nums[i]>0 && nums[i]<=100000){
                ans[nums[i]]=1;
            }
            i++;
        }
        for(i=1;i<=100000;i++){
            if(ans[i]==0){
                return i;
            }
        }
        return -1;
    }
}