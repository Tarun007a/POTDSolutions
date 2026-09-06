package Leetcodecontest.weekly518;


// Done after the contest
// tc & sc - O(n * m * k * 4)
class Solution {
    int n, m;
    int[][][][] dp;
    int[] delRow = {-1, 0, +1, 0};
    int[] delCol = {0, +1, 0, -1};

    private int helper(int row, int col, int k, int dir, int[][] grid) {
        if(row == n-1 && col == m-1) return 0;

        if(dp[row][col][k][dir] != -2) return dp[row][col][k][dir];

        int min = -1;

        for(int i = 0; i < 4; i++) {
            int newRow = delRow[i] + row;
            int newCol = delCol[i] + col;
            int newK = k;
            if(dir != 4 && dir != i) newK--;

            if(newK < 0) continue;

            if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < m) {
                int newCost = helper(newRow, newCol, newK, i, grid);

                if(min == -1 && newCost != -1)
                    min = grid[newRow][newCol] + newCost;
                else if(min != -1 && newCost != -1)
                    min = Math.min(min, grid[newRow][newCol] + newCost);
            }
        }
        return dp[row][col][k][dir] = min;
    }

    public int minCost(int[][] grid, int k) {
        n = grid.length;
        m = grid[0].length;

        dp = new int[n+1][m+1][k+1][5];

        for(int i = 0; i < n+1; i++) {
            for(int j = 0; j < m+1; j++) {
                for(int p = 0; p < k+1; p++) {
                    for(int q = 0; q < 5; q++) {
                        dp[i][j][p][q] = -2;
                    }
                }
            }
        }

        int result = helper(0, 0, k, 4, grid);

        if(result == -1) return -1;
        return result + grid[0][0];
    }
}