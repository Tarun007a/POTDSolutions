package GFG;

// tc - O(n^3), sc - O(n^2)
class Solution {

    int[][] dp;
    int[] prefix;
    int k;

    private int sum(int i, int j) {
        if (i == 0) return prefix[j];
        return prefix[j] - prefix[i - 1];
    }

    private int solve(int i, int j) {
        if (i == j) return 0;
        if (dp[i][j] != -1) return dp[i][j];

        int res = Integer.MAX_VALUE;

        for (int p = i; p < j; p += (k - 1)) {
            int left = solve(i, p);
            int right = solve(p + 1, j);

            if (left == Integer.MAX_VALUE || right == Integer.MAX_VALUE)
                continue;

            res = Math.min(res, left + right);
        }

        if ((j - i) % (k - 1) == 0) {
            res += sum(i, j);
        }

        return dp[i][j] = res;
    }

    public int mergeStones(int[] stones, int k) {
        int n = stones.length;
        this.k = k;

        if ((n - 1) % (k - 1) != 0) return -1;

        prefix = new int[n];
        prefix[0] = stones[0];
        for (int i = 1; i < n; i++) prefix[i] = prefix[i - 1] + stones[i];

        dp = new int[n][n];
        for (int[] row : dp) Arrays.fill(row, -1);

        return solve(0, n - 1);
    }
}