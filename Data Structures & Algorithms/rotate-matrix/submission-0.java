class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int m = n;

        // swap rows
        int bottom = n - 1, top = 0;
        for (int i = top; i < bottom; i++) {
            for (int j = 0; j < m; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[bottom][j];
                matrix[bottom][j] = temp;
            }
            bottom--;
        }

        for (int i = 0; i < n; i++) {
            for (int j = i; j < m; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
