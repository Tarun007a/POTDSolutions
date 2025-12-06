package GFG;

// tc - O(n*n), sc - O(n*n)
class Solution {
    int[][] dp;

    private int solve(int i, int j, int[] arr) {
        if (i > j) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        if (i == j) return dp[i][j] = arr[i];

        int pickLeft = arr[i] + Math.min(
                solve(i + 2, j, arr),
                solve(i + 1, j - 1, arr)
        );

        int pickRight = arr[j] + Math.min(
                solve(i + 1, j - 1, arr),
                solve(i, j - 2, arr)
        );

        return dp[i][j] = Math.max(pickLeft, pickRight);
    }

    public int maximumAmount(int[] arr) {
        int n = arr.length;
        dp = new int[n][n];

        for (int i = 0; i < n; i++)
            Arrays.fill(dp[i], -1);

        return solve(0, n - 1, arr);
    }
}
