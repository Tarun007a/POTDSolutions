package Leetcode;

// leetcode - 1510
// tc - O(n * sqrt(n)), sc - O(1)
class Solution {
    public boolean winnerSquareGame(int n) {
        if(n == 1) return true;
        boolean[] dp = new boolean[n+1];
        dp[0] = false;
        dp[1] = true;

        for(int i = 2; i <= n; i++) {
            boolean curr = true;

            for(int pow = 1; pow*pow <= i; pow++) {
                int idx = i - pow*pow;
                if(!dp[idx]) {
                    curr = false;
                    break;
                }
            }

            dp[i] = !curr;
        }
        return dp[n];
    }
}