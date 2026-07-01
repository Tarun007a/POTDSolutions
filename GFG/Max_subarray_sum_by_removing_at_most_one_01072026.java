package GFG;

// tc - O(n), sc - O(n)
class Solution {
    public int maxSumSubarray(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][2];

        dp[0][0] = arr[0];
        dp[0][1] = -100000;
        int max = arr[0];

        for(int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i-1][0] + arr[i], arr[i]);

            int useNow = dp[i-1][0];
            int used = Math.max(dp[i-1][1] + arr[i], arr[i]);
            dp[i][1] = Math.max(useNow, used);

            max = Math.max(max, Math.max(dp[i][0], dp[i][1]));
        }
        return max;
    }
}
