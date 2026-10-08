package GFG;

// tc - O(nlogn), sc - O(1)
class Solution {
    public int maxFrequency(int[] arr, int k) {
        int n = arr.length;
        int sum = 0;
        int st = 0;
        int result = 0;
        Arrays.sort(arr);

        for(int i = 0; i < n; i++) {
            int req = i - st;
            while(req * arr[i] - sum > k) {
                sum -= arr[st];
                st++;
                req = i - st;
            }

            sum += arr[i];
            result = Math.max(result, i - st + 1);
        }

        return result;
    }
}