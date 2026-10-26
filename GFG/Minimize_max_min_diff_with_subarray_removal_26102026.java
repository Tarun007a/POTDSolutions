package GFG;

// tc - o(n), sc - O(n)
class Solution {
    public int minDiff(int k, int[] arr) {
        int n = arr.length;
        k = n-k;
        int max = arr[0];
        int min = arr[0];
        int result = Integer.MAX_VALUE;
        int[] suffixMax = new int[n];
        int[] suffixMin = new int[n];

        suffixMax[n-1] = suffixMin[n-1] = arr[n-1];

        for(int i = n-2; i >= 0; i--) {
            suffixMax[i] = Math.max(suffixMax[i+1], arr[i]);
            suffixMin[i] = Math.min(suffixMin[i+1], arr[i]);
        }

        if(k == 0) return suffixMax[0] - suffixMin[0];

        result = suffixMax[n-k] - suffixMin[n-k];

        for(int i = 0; i < k; i++) {
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);

            if(i == k-1) {
                result = Math.min(result, max-min);
                break;
            }

            int idx = n - k + i + 1;

            int currMax = Math.max(max, suffixMax[idx]);
            int currMin = Math.min(min, suffixMin[idx]);

            result = Math.min(result, currMax - currMin);
        }

        return result;
    }
}