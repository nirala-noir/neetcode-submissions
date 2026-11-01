class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int itr : nums) {
            map.putIfAbsent(itr, 0);
            map.put(itr, map.get(itr) + 1);
        }

        // System.out.println(map);
        int n = map.size();
        int[][] arr = new int[n][2];
        int i = 0;
        for (Map.Entry<Integer, Integer> itr : map.entrySet()) {
            arr[i] = new int[2];
            arr[i][0] = itr.getKey();
            arr[i][1] = itr.getValue();
            // System.out.println(arr[i][0] + " " + arr[i][1]);

            i++;
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (a[1] == b[1]) {
                    return a[0] - b[0];
                }
                return b[1] - a[1];
            }
        });
        // for (i = 0; i < n; i++) {
        //     System.out.println(arr[i][0] + " " + arr[i][1]);
        // }

        int[] ans = new int[k];
        for (i = 0; i < k && i < n; i++) {
            ans[i] = arr[i][0];
        }
        return ans;
    }
}
