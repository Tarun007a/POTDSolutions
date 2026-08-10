package GFG;

// tc - O(n), sc - O(n)
class Solution {
    int[][] dp;

    private int helper(int i, int prev, int[] h, int[] l) {
        if(i == h.length) return 0;

        if(dp[i][prev] != -1) return dp[i][prev];

        int res = 0;

        if(prev == 0) res = h[i] + helper(i+1, 1, h, l);

        return dp[i][prev] = Math.max(res,
                Math.max(helper(i+1, 1, h, l) + l[i], helper(i+1, 0, h, l)));
    }

    public int maxTask(int[] h, int[] l) {
        int n = h.length;
        dp = new int[n][2];

        for(int[] row : dp) row[0] = row[1] = -1;

        return helper(0, 0, h, l);
    }
}