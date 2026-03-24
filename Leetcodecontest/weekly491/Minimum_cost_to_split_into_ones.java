package Leetcodecontest.weekly491;

// leetcode - 3857
class Solution {
    int[] dp;
    private int getMinCost(int n){
        if(n == 1) return 0;

        if(dp[n] != -1) return dp[n];

        int min = Integer.MAX_VALUE;
        for(int i = 1; i < n; i++){
            int curr = i * (n-i) + getMinCost(i) + getMinCost(n-i);
            min = Math.min(min, curr);
        }
        return dp[n] = min;
    }
    public int minCost(int n) {
        dp = new int[n+1];
        Arrays.fill(dp, -1);
        return getMinCost(n);
    }
}