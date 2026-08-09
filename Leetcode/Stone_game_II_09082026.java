package Leetcode;

// leetcode - 1140
// tc - O(n*n), sc - O(n*n)

// similar idea for game stratgy that expect max when our turn and expect min
// that opponent will return us the min score i.e. expect min when opponent turn
class Solution {
    int[][][] dp;

    private int helper(int i, int m, int turn, int[] piles) {
        int n = piles.length;
        if(i == n) return 0;

        if(dp[i][m][turn] != -1) return dp[i][m][turn];

        if(turn == 0) {
            int max = 0;
            int curr = 0;

            for(int x = 1; x <= 2 * m && i+x <= n; x++) {
                curr += piles[i+x-1];

                max = Math.max(max, curr + helper(i+x, Math.max(x, m), 1, piles));
            }
            return dp[i][m][turn] = max;
        }
        else {
            int min = Integer.MAX_VALUE;

            for(int x = 1; x <= 2 * m && i+x <= n; x++) {
                min = Math.min(min, helper(i+x, Math.max(x, m), 0, piles));
            }
            return dp[i][m][turn] = min;
        }
    }
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        dp = new int[n][n+1][2];

        for(int[][] a : dp) {
            for(int[] b : a) {a
                b[0] = b[1] = -1;
            }
        }

        return helper(0, 1, 0, piles);
    }
}
