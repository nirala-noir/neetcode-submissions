class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;

        Arrays.sort(intervals, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                if(a[1]==b[1]){
                    return a[0]-b[0];
                }
                return a[1]-b[1];
            }
        });

        int ans=0;
        int j=0;
        for(int i=1;i<n;i++){
            if(intervals[i][0]<intervals[j][1]){
                ans++;
            }else{
                j=i;
            }
        }
        return ans;
    }
}