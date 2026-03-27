package GFG;

// tc & sc - O(n * m * m)
class Solution {
    int n, m;
    int[][][] dp;

    private int helper(int i, int j1, int j2, int[][] grid) {
        if(j1 < 0 || j1 >= m || j2 < 0 || j2 >= m) return -1;
        if(i == n) return 0;

        if(dp[i][j1][j2] != -2) return dp[i][j1][j2];

        int curr = grid[i][j1];
        if(j1 != j2) curr += grid[i][j2];
        int max = 0;

        for(int del1 = -1; del1 <= 1; del1++) {
            for(int del2 = -1; del2 <= 1; del2++) {
                int result = helper(i+1, j1 + del1, j2 + del2, grid);
                max = Math.max(max, result);
            }
        }
        return dp[i][j1][j2] = curr + max;
    }

    public int maxChocolate(int grid[][]) {
        n = grid.length;
        m = grid[0].length;

        dp = new int[n][m][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                Arrays.fill(dp[i][j], -2);
            }
        }

        return helper(0, 0, m-1, grid);
    }
}