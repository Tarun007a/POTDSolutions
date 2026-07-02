package GFG;

// tc & sc - O(n*k)
class Solution {
    public boolean divisibleByK(int[] arr, int k) {
        int n = arr.length;

        boolean[][] dp = new boolean[n][k];

        dp[n - 1][arr[n - 1] % k] = true;

        for (int i = n - 2; i >= 0; i--) {
            dp[i][arr[i] % k] = true;

            for (int j = 0; j < k; j++) {
                if (dp[i + 1][j]) {
                    dp[i][j] = true;

                    int newVal = (arr[i] + j) % k;
                    dp[i][newVal] = true;
                }
            }
        }

        return dp[0][0];
    }
}