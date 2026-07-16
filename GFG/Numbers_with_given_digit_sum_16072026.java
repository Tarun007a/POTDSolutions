package GFG;

// tc & sc - O(n*sum)
class Solution {
    int[][] dp;

    private int getWays(int n, int req, int curr) {
        if(n == 0 && curr == req) return 1;
        if(n == 0 || curr > req) return 0;

        if(dp[n][curr] != -1) return dp[n][curr];

        int currWays = 0;

        if(curr != 0) currWays = getWays(n-1, req, curr);

        for(int i = 1; i < 10; i++) {
            currWays += getWays(n-1, req, curr+i);
        }
        return dp[n][curr] = currWays;
    }

    public int countWays(int n, int sum) {
        dp = new int[n+1][sum+1];

        for(int[] row : dp) Arrays.fill(row, -1);

        int result = getWays(n, sum, 0);

        return result == 0 ? -1 : result;
    }
};