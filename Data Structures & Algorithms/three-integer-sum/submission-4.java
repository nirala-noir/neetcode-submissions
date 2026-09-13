class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
       
        for(int i=0;i<n;i++){
            
            int left=i+1, right=n-1;
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            
            while(left<right){
                int sum=nums[i]+nums[left]+nums[right];
                if(sum==0){
                    list.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;

                    while(left<right && nums[left]==nums[left-1]){
                        left++;
                    }
                    while(left<right && nums[right]== nums[right+1]){
                        right--;
                    }
                }else if(sum<0){
                    left++;
                }else{
                    right--;
                }
            }
            
        }
        return list;
        
    }
}
