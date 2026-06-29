package GFG;

// tc & sc - O(n*m)
class Solution {
    private int n, m;
    private int[][] dp;

    private int getMaxProduct(int i, int j, int[] a, int[] b) {
        if(j == m) return 0;
        if(i == n) return -1;

        if(dp[i][j] != -2) return dp[i][j];

        int curr = -1;

        int notTake = getMaxProduct(i+1, j+1, a, b);
        if(notTake != -1) curr = notTake + a[i] * b[j];

        curr = Math.max(curr, getMaxProduct(i+1, j, a, b));

        return dp[i][j] = curr;
    }

    public int maxDotProduct(int[] a, int[] b) {
        n = a.length;
        m = b.length;

        dp = new int[n][m];

        for(int[] row : dp) Arrays.fill(row, -2);

        return getMaxProduct(0, 0, a, b);
    }
}