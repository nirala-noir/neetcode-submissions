class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;

        List<int[]> temp = new ArrayList<>();

        int i = 0;
        while (i < n) {
            if (newInterval[0] > intervals[i][1]) {
                temp.add(new int[] {intervals[i][0], intervals[i][1]});
            } else {
                break;
            }
            i++;
        }

        while (i < n) {
            if (newInterval[1] >= intervals[i][0]) {
                newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
                newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            } else {
                break;
            }
            i++;
        }
        temp.add(new int[] {newInterval[0], newInterval[1]});

        while (i < n) {
            temp.add(new int[] {intervals[i][0], intervals[i][1]});
            i++;
        }

        int len = temp.size();
        // System.out.println(len);

        return temp.toArray(new int[temp.size()][]);
    }
}
