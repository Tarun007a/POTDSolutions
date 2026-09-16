package Leetcode;

// leetcode - 1621
// tc & sc - O(n * k)
class Solution {
    int mod = (int)(1e9) + 7;
    int[][][] dp;

    private int helper(int i, int took, int k, int n) {
        if(k == 0) return n-i;
        if(i == n-1) return 0;

        if(dp[i][k][took] != -1) return dp[i][k][took];

        if(took == 1) {
            return dp[i][k][took] = ((helper(i+1, 1, k, n)
                    + helper(i+1, 1, k-1, n)) % mod
                    + helper(i+1, 0, k, n)) % mod;
        }

        return dp[i][k][took] = (helper(i+1, 0, k, n) +
                helper(i+1, 1, k-1, n)) % mod;
    }

    public int numberOfSets(int n, int k) {
        dp = new int[n][k+1][2];

        for(int[][] a : dp) {
            for(int[] b : a) {
                b[0] = b[1] = -1;
            }
        }

        return helper(0, 0, k, n);
    }
}