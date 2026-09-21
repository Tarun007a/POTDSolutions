package Leetcode;

// leetcode - 3524
// tc & sc - O(n*k)
class Solution {
    public long[] resultArray(int[] nums, int k) {
        int n = nums.length;
        long[][] dp = new long[n][k];
        dp[0][nums[0]%k] = 1;

        for(int i = 1; i < n; i++) {
            int val = nums[i] % k;

            dp[i][val]++;

            for (int r = 0; r < k; r++) {
                int newRem = (int) ((long) r * val % k);
                dp[i][newRem] += dp[i - 1][r];
            }
        }

        long[] result = new long[k];

        for (int i = 0; i < n; i++) {
            for (int r = 0; r < k; r++) {
                result[r] += dp[i][r];
            }
        }
        return result;
    }
}