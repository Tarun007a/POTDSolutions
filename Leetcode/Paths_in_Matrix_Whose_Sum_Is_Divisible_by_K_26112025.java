package Leetcode;

// tc - O(n*m*k), sc - O(n*m*k)
class Solution {
    int[][][] dp;
    int mod = (int)1e9 + 7;
    private int getPaths(int row, int col, int n, int m, int curr, int[][] grid, int k){
        if(row == n-1 && col == m-1) return (curr + grid[row][col])%k == 0 ? 1 : 0;

        if(dp[row][col][curr] != -1) return dp[row][col][curr];

        int down = 0;
        int right = 0;
        int cost = (curr + grid[row][col])%k;

        if(row < n-1) down = getPaths(row+1, col, n, m, cost, grid, k);
        if(col < m-1) right = getPaths(row, col+1, n, m, cost, grid, k);

        return dp[row][col][curr] = (down%mod + right%mod) % mod;
    }
    public int numberOfPaths(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        dp = new int[n][m][k];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++) Arrays.fill(dp[i][j], -1);
        }

        return getPaths(0, 0, n, m, 0, grid, k);
    }
}