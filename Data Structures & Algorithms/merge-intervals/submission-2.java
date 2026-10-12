class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        if (n == 1) {
            return intervals;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0]) {
                    return a[1] - b[1];
                }
                return a[0] - b[0];
            }
        });
        // for (int i = 0; i < n; i++) {
        //     System.out.print(intervals[i][0] + " " + intervals[i][1] + " ");
        // }

        List<int[]> ans = new ArrayList<>();
        boolean checkLastElement = false;

        for (int i = 1; i < n; i++) {
            if (intervals[i][0] <= intervals[i - 1][1]) {
                intervals[i][0] = Math.min(intervals[i][0], intervals[i - 1][0]);
                intervals[i][1] = Math.max(intervals[i][1], intervals[i - 1][1]);
            } else {
                ans.add(new int[] {intervals[i - 1][0], intervals[i - 1][1]});
            }
            if (i == n - 1) {
                ans.add(new int[] {intervals[i][0], intervals[i][1]});
            }
        }
        if (checkLastElement) {
            ans.add(new int[] {intervals[n - 1][0], intervals[n - 1][1]});
        }

        int len = ans.size();
        // System.out.println(len);
        int i = 0;
        int[][] finalAns = new int[len][2];
        for (int[] itr : ans) {
            finalAns[i][0] = itr[0];
            finalAns[i][1] = itr[1];
            i++;
        }
        return finalAns;
    }
}
