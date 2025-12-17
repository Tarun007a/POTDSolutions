package Leetcode;

// leetcode - 3573
// tc - O(n*k), sc - O(n*k)
class Solution {
    long[][][] dp;
    int[] prices;
    int n;

    private long helper(int i, int k, int state) {

        if (k < 0) return Long.MIN_VALUE / 2;

        if (i == n) {
            return state == 0 ? 0 : Long.MIN_VALUE / 2;
        }

        if (dp[i][k][state] != Long.MIN_VALUE)
            return dp[i][k][state];

        long ans = Long.MIN_VALUE / 2;

        if (state == 0) {
            ans = helper(i + 1, k, 0);

            if (k > 0) {
                ans = Math.max(ans, helper(i + 1, k, 1) - prices[i]);
                ans = Math.max(ans, helper(i + 1, k, 2) + prices[i]);
            }
        }
        else if (state == 1) {
            ans = helper(i + 1, k, 1);
            ans = Math.max(ans, prices[i] + helper(i + 1, k - 1, 0));
        }
        else {
            ans = helper(i + 1, k, 2);
            ans = Math.max(ans, -prices[i] + helper(i + 1, k - 1, 0));
        }

        return dp[i][k][state] = ans;
    }

    public long maximumProfit(int[] prices, int k) {
        this.prices = prices;
        this.n = prices.length;

        dp = new long[n][k + 1][3];
        for (int i = 0; i < n; i++)
            for (int j = 0; j <= k; j++)
                Arrays.fill(dp[i][j], Long.MIN_VALUE);

        return helper(0, k, 0);
    }
}
