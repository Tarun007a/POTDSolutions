package GFG;

// tc - O(n), sc - O(1)
class Solution {
    public int maxPackages(int[] arr, int totalTime) {
        int n = arr.length;
        int sum = 0;
        int result = 0;

        for(int i = 0; i < Math.min(totalTime, n); i++) sum += arr[i];

        result = sum;
        for(int i = totalTime; i < n; i++) {
            sum = sum + arr[i] - arr[i - totalTime];
            result = Math.max(result, sum);
        }
        return result;
    }
}