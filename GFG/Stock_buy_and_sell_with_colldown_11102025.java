package GFG;

// tc - O(n), sc - O(n)
class Solution {
    int[][] dp;
    private int helper(int i, int buy, int[] arr){
        if(i >= arr.length) return 0;

        if(dp[i][buy] != -1) return dp[i][buy];

        int take = 0;
        int notTake = 0;
        if(buy == 1){
            take = -arr[i] + helper(i+1, 0, arr);
            notTake = helper(i+1, 1, arr);
        }
        else{
            take = arr[i] + helper(i+2, 1, arr);
            notTake = helper(i+1, 0, arr);
        }
        return dp[i][buy] = Math.max(take, notTake);
    }

    public int maxProfit(int arr[]) {
        int n = arr.length;
        dp = new int[n][2];
        for(int i = 0; i < n; i++){
            dp[i][0] = dp[i][1] = -1;
        }
        return helper(0, 1, arr);
    }
}
