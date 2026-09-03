package GFG;

// tc - O(n), sc - O(n)
class Solution {
    int[][] dp;
    private int helper(int i, int prev, int[] arr) {
        if(i == arr.length) return 0;

        if(dp[i][prev] != -1) return dp[i][prev];

        int prevVal = prev;
        if(prev == 0) prevVal = arr[i-1];

        // make this 1
        int max = Math.abs(prevVal - 1) + helper(i+1, 1, arr);

        max = Math.max(max, Math.abs(prevVal - arr[i]) + helper(i+1, 0, arr));

        return dp[i][prev] = max;
    }

    public int maxDiffSum(int[] arr) {
        int n = arr.length;
        dp = new int[n][2];

        for(int[] row : dp) row[0] = row[1] = -1;

        return Math.max(helper(1, 0, arr), helper(1, 1, arr));
    }
}