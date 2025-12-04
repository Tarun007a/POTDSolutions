package GFG;

// tc - O(n^3), sc - O(n^2)
class Solution {
    int[][] dp;
    int[] prefix;

    int sum(int i, int j) {
        if (i > j) return 0;
        return prefix[j] - (i == 0 ? 0 : prefix[i - 1]);
    }

    int solve(int i, int j, int[] freq) {
        if (i > j) return 0;
        if (i == j) return freq[i];

        if (dp[i][j] != -1) return dp[i][j];

        int totalFreq = sum(i, j);
        int ans = Integer.MAX_VALUE;

        for (int r = i; r <= j; r++) {
            int cost = solve(i, r - 1, freq)
                    + solve(r + 1, j, freq)
                    + totalFreq;
            ans = Math.min(ans, cost);
        }

        return dp[i][j] = ans;
    }

    public int minCost(int[] keys, int[] freq) {
        int n = keys.length;
        dp = new int[n][n];
        for (int[] row : dp) Arrays.fill(row, -1);

        prefix = new int[n];
        prefix[0] = freq[0];
        for (int i = 1; i < n; i++) prefix[i] = prefix[i - 1] + freq[i];

        return solve(0, n - 1, freq);
    }
}
