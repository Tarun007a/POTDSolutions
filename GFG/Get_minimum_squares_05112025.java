package GFG;

// tc - O(n * sqrt(n)), sc - O(n * sqrt(n))
class Solution {
    private int[][] dp;
    private int helper(int n, int curr){
        if(n == 0) return 0;
        if(curr == 1) return n;

        if(dp[n][curr] != -1) return dp[n][curr];

        int take = 100000;
        if(curr*curr <= n) take = helper(n - curr*curr, curr) + 1;

        int notTake = helper(n, curr-1);
        return dp[n][curr] = Math.min(take, notTake);
    }
    public int minSquares(int n) {
        int max = (int)Math.sqrt(n);

        dp = new int[n+1][max+1];
        for(int[] row : dp) Arrays.fill(row, -1);

        return helper(n, max);
    }
}