package GFG;

// tc & sc - O(n)
class Solution {
    public int maxDiffSubArrays(int[] arr) {
        int n = arr.length;
        int result = 0;
        int max = arr[n-1];
        int min = arr[n-1];
        int currMin = 0;
        int currMax = 0;
        int[] maxSum = new int[n];
        int[] minSum = new int[n];

        for(int i = n-1; i >= 0; i--) {
            currMin += arr[i];
            currMax += arr[i];
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);

            if(currMin > 0) currMin = 0;
            if(currMax < 0) currMax = 0;

            if(currMin == 0) minSum[i] = min;
            else minSum[i] = currMin;

            if(currMax == 0) maxSum[i] = max;
            else maxSum[i] = currMax;
        }

        max = arr[0];
        min = arr[0];
        currMin = 0;
        currMax = 0;

        for(int i = 0; i < n-1; i++) {
            currMin += arr[i];
            currMax += arr[i];
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);

            if(currMin > 0) currMin = 0;
            if(currMax < 0) currMax = 0;

            if(currMin == 0) result = Math.max(result, Math.abs(min-maxSum[i+1])); // minSum[i] = min;
            else result = Math.max(result, Math.abs(currMin-maxSum[i+1])); // minSum[i] = currMin;

            if(currMax == 0) result = Math.max(result, Math.abs(max-minSum[i+1])); // maxSum[i] = max;
            else result = Math.max(result, Math.abs(currMax-minSum[i+1])); // maxSum[i] = currMax;
        }
        return result;
    }
}


