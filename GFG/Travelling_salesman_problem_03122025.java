package GFG;

// tc - O(n * 2^n), sc - O(n * 2^n)
class Solution {
    static final int INF = (int)1e9;
    int[][] cost;
    int n;
    int[][] dp;

    private int solve(int mask, int u) {
        if (mask == (1 << n) - 1) {
            return cost[u][0];
        }

        if (dp[mask][u] != -1) return dp[mask][u];

        int ans = INF;

        for (int v = 0; v < n; v++) {
            if ((mask & (1 << v)) == 0) {
                int newMask = mask | (1 << v);
                ans = Math.min(ans, cost[u][v] + solve(newMask, v));
            }
        }

        return dp[mask][u] = ans;
    }

    public int tsp(int[][] cost) {
        this.cost = cost;
        n = cost.length;

        int maxMask = 1 << n;

        dp = new int[maxMask][n];
        for (int i = 0; i < maxMask; i++)
            Arrays.fill(dp[i], -1);

        return solve(1, 0);
    }
}