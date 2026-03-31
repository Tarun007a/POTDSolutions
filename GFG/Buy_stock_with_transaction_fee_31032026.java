package GFG;

// tc & sc - O(n)
class Solution {
    int[][] dp;
    int min = Integer.MIN_VALUE;

    private int helper(int idx, int isBuyed, int[] arr, int k) {
        if(idx == arr.length) return 0;

        if(dp[idx][isBuyed] != min) return dp[idx][isBuyed];

        if(isBuyed == 1) {
            return dp[idx][isBuyed] = Math.max(helper(idx+1, 0, arr, k) + arr[idx] -k, helper(idx+1, 1, arr, k));
        }
        else {
            return dp[idx][isBuyed] = Math.max(helper(idx+1, 1, arr, k) - arr[idx], helper(idx+1, 0, arr, k));
        }
    }
    public int maxProfit(int arr[], int k) {
        int n = arr.length;

        dp = new int[n][2];

        for(int i = 0; i < n; i++) {
            dp[i][0] = dp[i][1] = min;
        }
        return helper(0, 0, arr, k);
    }
}