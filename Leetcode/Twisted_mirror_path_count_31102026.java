package Leetcode;

// leetcode - 3665
// tc - O(n * m), sc - O(n*m)
class Solution {
    int n, m;
    long mod = (long)(1e9) + 7;
    long[][][] dp;

    private long helper(int row, int col, int dir, int[][] grid) {
        if(row < 0 || row >= n || col < 0 || col >= m) return 0;

        if(row == n-1 && col == m-1) return 1;

        if(dp[row][col][dir] != -1) return dp[row][col][dir];

        if(grid[row][col] == 0) {
            return dp[row][col][dir] = (helper(row+1, col, 0, grid) + helper(row, col+1, 1, grid)) % mod;
        }

        if(dir == 0) return dp[row][col][dir] = helper(row, col+1, 1, grid);
        else return dp[row][col][dir] = helper(row+1, col, 0, grid);
    }

    public int uniquePaths(int[][] grid) {
        this.n = grid.length;
        this.m = grid[0].length;
        dp = new long[n][m][2];

        for(long[][] arr1 : dp) {
            for(long[] arr2 : arr1) {
                arr2[0] = arr2[1] = -1;
            }
        }

        return (int)helper(0, 0, 0, grid);
    }
}
