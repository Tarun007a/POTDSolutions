package GFG;

// tc - O(n*n), sc - O(n)
class Solution {
    public int maxSumIS(int arr[]) {
        int n = arr.length;

        int result = arr[0];
        int[] dp = new int[n];
        dp[0] = arr[0];

        for(int i = 1; i < n; i++){
            dp[i] = arr[i];
            for(int j = 0; j < i; j++){
                if(arr[i] > arr[j] && dp[i] < arr[i] + dp[j]){
                    dp[i] = dp[j] + arr[i];
                    result = Math.max(result, dp[i]);
                }
            }
        }
        return result;
    }
}