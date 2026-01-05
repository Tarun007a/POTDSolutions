package GFG;

// tc - O(n), sc - O(1)
class Solution {
    public int maxSubarraySum(int[] arr, int k) {
        int sum = 0;
        int max = 0;

        for(int i = 0; i < k; i++) sum += arr[i];
        max = sum;

        for(int i = k; i < arr.length; i++){
            sum -= arr[i-k];
            sum += arr[i];
            max = Math.max(max, sum);
        }
        return max;
    }
}
