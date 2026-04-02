package Leetcode;

// leetcode - 3418
// tc & sc - O(n*m)
class Solution {
    int min = -10000000;
    int unvisited = -100000000;
    int n, m;
    int[][][] dp;

    private int helper(int i, int j, int k, int[][] coins) {
        if(i == n || j == m || k < 0) return min;

        if(i == n-1 && j == m-1) {
            if(k > 0) return Math.max(coins[i][j], 0);
            return coins[i][j];
        }

        if(dp[i][j][k] != unvisited) return dp[i][j][k];

        if(coins[i][j] < 0) {
            // right
            int right = Math.max(helper(i, j+1, k-1, coins),
                    helper(i, j+1, k, coins) + coins[i][j]);

            // down
            int down = Math.max(helper(i+1, j, k-1, coins),
                    helper(i+1, j, k, coins) + coins[i][j]);

            return dp[i][j][k] = Math.max(right, down);
        }
        else {
            return dp[i][j][k] = coins[i][j] + Math.max(helper(i, j+1, k, coins), helper(i+1, j, k, coins));
        }
    }
    public int maximumAmount(int[][] coins) {
        n = coins.length;
        m = coins[0].length;

        dp = new int[n][m][3];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                dp[i][j][0] = dp[i][j][1] = dp[i][j][2] = unvisited;
            }
        }

        return helper(0, 0, 2, coins);
    }
}
