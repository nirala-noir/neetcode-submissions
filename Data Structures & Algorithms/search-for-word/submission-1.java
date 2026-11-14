class Solution {
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (checkExistence(i, j, board, word, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    boolean checkExistence(int i, int j, char[][] board, String word, int index) {
        // All characters matched
        if (index == word.length()) {
            return true;
        }

        // Boundary check
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            return false;
        }

        // Character mismatch
        if (board[i][j] != word.charAt(index)) {
            return false;
        }

        // Mark current cell as visited
        char temp = board[i][j];
        board[i][j] = '#';

        // Explore all four directions
        boolean found = checkExistence(i, j + 1, board, word, index + 1)
            || checkExistence(i + 1, j, board, word, index + 1)
            || checkExistence(i - 1, j, board, word, index + 1)
            || checkExistence(i, j - 1, board, word, index + 1);

        // Backtrack
        board[i][j] = temp;

        return found;
    }
}