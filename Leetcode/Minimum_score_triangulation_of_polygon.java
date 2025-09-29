package Leetcode;

// leetcode 1039
// Similar to mcm(matrix chain multiplication)

class Solution {
    int[][] dp;
    public int helper(int[] values, int i, int j, int res) {
        if (j == 0) j = values.length - 1;
        if (dp[i][j] != 0) return dp[i][j];
        for (int k = i + 1; k < j; k++) {
            res = Math.min(res == 0 ? Integer.MAX_VALUE : res,
                    helper(values, i, k, 0) +
                            values[i] * values[k] * values[j] +
                            helper(values, k, j, 0));
        }
        return dp[i][j] = res;
    }
    public int minScoreTriangulation(int[] values) {
        dp = new int[51][51];
        return helper(values, 0, values.length-1, 0);
    }
}
