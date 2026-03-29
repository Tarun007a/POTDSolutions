package GFG;

// Here is the logic,
// here we want to divide in two subset so let us say the sum of two subset
// are x1, x2 and also let the total sum of array be sum, now we want
// x1 - x2 = k,  also we can say that x1 + x2 = sum - now using elimination
// x1 - x2 = k
// x1 + x2 = sum
// 2x1 = sum + k -> x1 = (sum + k) / 2; and if (sum+k)/2 is a floting point
// number then it is impossibe to create such subarray so return 0
// Now we just need to find sub array with sum x1 and the left part will have
// sum x2 as x1 + x2 = k

// tc & sc - O(n * total)
class Solution {
    public int countPartitions(int[] arr, int diff) {
        int n = arr.length;
        int sum = Arrays.stream(arr).sum();

        if((sum + diff) % 2 == 1 || diff > sum) return 0;

        int x1 = (sum + diff) / 2;

        int[][] dp = new int[n][sum+1];

        dp[n-1][arr[n-1]] = 1;
        dp[n-1][0] = 1;

        for(int i = n-2; i >= 0; i--) {
            int num = arr[i];

            for(int j = 0; j <= sum; j++) {
                if(dp[i+1][j] > 0) {    // we dont need this
                    dp[i][j] += dp[i+1][j];         // Not take
                    dp[i][j + num] += dp[i+1][j];   // Take
                }
            }
        }
        return dp[0][x1];
    }
}

