/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        int n = intervals.size();
        if(n==0){
            return 0;
        }
        int[] arr = new int[n];
        int[] dept = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=intervals.get(i).start;
            dept[i]=intervals.get(i).end;
        }

        Arrays.sort(arr);
        Arrays.sort(dept);
        int ans=Integer.MIN_VALUE;

        int i=0,j=0;
        int temp=0;
        while(i<n && j<n){
            if(arr[i]<dept[j]){
                temp++;
                i++;
            }else{
                j++;
                temp--;
            }
            ans = Math.max(ans, temp);
        }

        while(i<n){
            temp++;
                i++;
                ans = Math.max(ans, temp);
        }
        while(j<n){
            temp--;
                j++;
                ans = Math.max(ans, temp);
        }
        return ans;
    }
}
