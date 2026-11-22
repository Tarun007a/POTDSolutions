package Leetcodecontest.weekly529;

class Solution {
    int n;
    Long[][] dp;

    private long helper(int i, boolean isLenEven, int[] nums) {
        if(i == n-1) {
            if(isLenEven) return 0;
            return 10000000000000000l;
        }

        int idx = isLenEven ? 0 : 1;

        if(dp[i][idx] != null) return dp[i][idx];

        return dp[i][idx] = Math.min(helper(i+1, isLenEven, nums),
                helper(i+1, !isLenEven, nums) + nums[i]);
    }

    public long minCost(int[] nums) {
        n = nums.length;
        long result = 0;
        dp = new Long[n][2];

        for(int i = 0; i < n; i++) {
            dp[i][0] = dp[i][1] = null;
        }

        return helper(1, true, nums) + nums[0] + nums[n-1];
    }
}