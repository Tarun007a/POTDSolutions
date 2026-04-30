package Leetcode;

// leetcode - 3742
// tc & sc - O(n*m*k)
class Solution {
    int n, m;
    int[][][] dp;

    private int  helper(int i, int j, int k, int[][] grid) {
        if(k < 0) return -1;

        if(i == n-1 && j == m-1) {
            if(grid[i][j] == 0) return 0;
            if(k != 0) return grid[i][j];
            return -1;
        }

        if(i == n || j == m) return -1;

        if(dp[i][j][k] != -2) return dp[i][j][k];

        int remove = grid[i][j] == 0 ? 0 : 1;

        int right = helper(i, j+1, k-remove, grid);
        int down = helper(i+1, j, k-remove, grid);

        if(right == -1 && down == -1) return dp[i][j][k] =-1;

        return dp[i][j][k] = Math.max(right, down) + grid[i][j];
    }

    public int maxPathScore(int[][] grid, int k) {
        n = grid.length;
        m = grid[0].length;

        dp = new int[n][m][k+1];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) Arrays.fill(dp[i][j], -2);
        }
        return helper(0, 0, k, grid);
    }
}