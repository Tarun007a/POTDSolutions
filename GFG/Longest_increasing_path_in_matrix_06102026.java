package GFG;

// tc & sc - O(n*m)
class Solution {
    int n, m;
    int[][] dp;
    int[] delRow = {-1, 0, +1, 0};
    int[] delCol = {0, +1, 0, -1};

    private int helper(int row, int col, int[][] matrix) {
        if(dp[row][col] != -1) return dp[row][col];

        int curr = 0;

        for(int i = 0; i < 4; i++) {
            int newRow = row + delRow[i];
            int newCol = col + delCol[i];

            if(newRow < n && newRow >= 0 && newCol < m && newCol >= 0 &&
                    matrix[newRow][newCol] > matrix[row][col]) {
                curr = Math.max(curr, helper(newRow, newCol, matrix));
            }
        }
        return dp[row][col] = 1 + curr;
    }

    public int longIncPath(int[][] matrix, int n, int m) {
        this.n = n;
        this.m = m;
        dp = new int[n][m];

        for(int[] row : dp) Arrays.fill(row, -1);

        int result = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(dp[i][j] == -1) {
                    int curr = helper(i, j, matrix);
                    result = Math.max(result, curr);
                }
            }
        }

        // for(int[] row : dp) System.out.println(Arrays.toString(row));

        return result;
    }
}