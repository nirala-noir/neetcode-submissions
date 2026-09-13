class Solution {
    public int maxArea(int[] heights) {
        int i=0;
        int n=heights.length;

        int ans=0;
        while(i<n){
            ans = Math.max(ans, Math.min(heights[i], heights[n-1])*(n-1-i));

            if(heights[i]<heights[n-1]){
                i++;
            }else{
                n--;
            }
        }
        return ans;
        
    }
}
