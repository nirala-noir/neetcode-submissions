class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    countIsland(i, j, n, m, grid);
                    count++;
                }
            }
        }
        return count;
    }
    void countIsland(int s, int e, int n, int m, char[][] grid) {
        if (s < 0 || s >= n || e < 0 || e >= m || grid[s][e] == '0' || grid[s][e] == '#') {
            return;
        }
        if (grid[s][e] == '1') {
            grid[s][e] = '#';
        }
        countIsland(s + 1, e, n, m, grid);
        countIsland(s - 1, e, n, m, grid);
        countIsland(s, e + 1, n, m, grid);
        countIsland(s, e - 1, n, m, grid);
    }
}
