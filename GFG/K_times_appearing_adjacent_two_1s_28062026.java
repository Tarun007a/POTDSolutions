package GFG;

// tc - O(n*k), sc - O(n*k)
class Solution {
    int[][][] dp;
    private final int MOD = 1000_000_007;

    private int getCount(int prev, int n, int k) {
        if(n == 0) {
            if(k == 0) return 1;
            else return 0;
        }

        if(dp[n][k][prev] != -1) return dp[n][k][prev];

        int curr = getCount(0, n-1, k);

        if(k == 0 && prev == 1) return dp[n][k][prev] = curr;

        if(prev == 1) curr += getCount(1, n-1, k-1);
        else curr += getCount(1, n-1, k);

        return dp[n][k][prev] = curr % MOD;
    }

    public int countStrings(int n, int k) {
        dp = new int[n+1][k+1][2];

        for(int[][] a : dp) {
            for(int[]b : a) {
                b[0] = b[1] = -1;
            }
        }
        return getCount(0, n, k);
    }
}