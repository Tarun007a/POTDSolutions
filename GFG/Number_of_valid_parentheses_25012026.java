package GFG;

// tc- O(n*n), sc - O(1)
class Solution {
    int[][] dp;

    private int getCount(int open, int currLen, int n){
        if(currLen == n) return open == 0 ? 1 : 0;

        if(dp[open][currLen] != -1) return dp[open][n];

        int openBracket = getCount(open+1, currLen+1, n);
        int closeBracket = 0;
        if(open > 0) closeBracket = getCount(open-1, currLen+1, n);

        return dp[open][n]= openBracket + closeBracket;
    }

    int findWays(int n) {
        dp = new int[n+1][n+1];
        for(int[] row : dp) Arrays.fill(row, -1);

        return getCount(0, 0, n);
    }
}

