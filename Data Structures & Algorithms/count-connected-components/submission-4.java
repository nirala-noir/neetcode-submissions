class Solution {
    public int countComponents(int n, int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int[] itr : edges) {
            if (map.containsKey(itr[0])) {
                map.get(itr[0]).add(itr[1]);
            } else {
                List<Integer> temp = new ArrayList<>();
                temp.add(itr[1]);
                map.put(itr[0], temp);
            }

            if (map.containsKey(itr[1])) {
                map.get(itr[1]).add(itr[0]);
            } else {
                List<Integer> temp = new ArrayList<>();
                temp.add(itr[0]);
                map.put(itr[1], temp);
            }
        }

        boolean[] visited = new boolean[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, map, visited);
                ans++;
            }
        }
        return ans;
    }
    void dfs(int start, Map<Integer, List<Integer>> map, boolean[] visited) {
        if (visited[start]) {
            return;
        }

        visited[start] = true;
        if (map.containsKey(start)) {
            List<Integer> list = map.get(start);

            for (Integer itr : list) {
                if (!visited[itr])
                    dfs(itr, map, visited);
            }
        }
    }
}
