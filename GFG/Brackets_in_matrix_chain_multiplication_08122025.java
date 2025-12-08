package GFG;

// tc - O(n*n), sc - O(n*n)
class Solution {
    int[][] dp;
    int[][] split;

    private int mcm(int i, int j, int[] arr) {
        if (i == j) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        int min = Integer.MAX_VALUE;

        for (int k = i; k < j; k++) {
            int left = mcm(i, k, arr);
            int right = mcm(k + 1, j, arr);

            int cost = left + right + arr[i - 1] * arr[k] * arr[j];

            if (cost < min) {
                min = cost;
                split[i][j] = k;
            }
        }

        return dp[i][j] = min;
    }

    private String build(int i, int j){
        if(i == j) return (char)('A'+i-1) + "";

        int k = split[i][j];
        String left = build(i, k);
        String right = build(k+1, j);

        return "(" + left + right + ")";
    }

    public String matrixChainOrder(int arr[]) {
        int n = arr.length;

        dp = new int[n][n];
        split = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
            Arrays.fill(split[i], -1);
        }

        mcm(1, n-1, arr);
        return build(1, n-1);
    }
}
