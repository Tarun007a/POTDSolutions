package GFG;

// tc - O(n), sc - O(n)
class Solution {
    public int maximumSubarray(int[] arr) {
        int n = arr.length;

        if(n == 1) return arr[0] * arr[0];

        int result = 0;
        int sum = Math.max(arr[n-1], 0);

        int[] prefixSum = new int[n+1];

        prefixSum[n-1] = sum;

        for(int i = n-2; i >= 0; i--) {
            sum = Math.max(sum + arr[i], 0);

            prefixSum[i] = sum;
        }

        sum = Math.max(arr[0], 0);
        result = arr[0] * arr[0] + prefixSum[1];

        for(int i = 1; i < n; i++) {
            result = Math.max(arr[i] * arr[i] + sum + prefixSum[i+1], result);

            sum = Math.max(sum + arr[i], 0);
        }
        return result;
    }
}