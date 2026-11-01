class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for(int itr:nums){
            set.add(itr);
        }

        //check now
        int ans =0;
        for(int itr:set){
            if(!set.contains(itr-1)){
                int len =0;
                while(set.contains(itr+len)){
                    len++;
                }
                ans=Math.max(ans, len);
            }
        }

        return ans;
        
    }
}
