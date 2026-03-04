package GFG;

// tc - O(n), sc - O(1)
class Solution {
    public int maxSubarrayXOR(int[] arr, int k) {
        int n = arr.length;
        int xor = 0;
        int max = 0;

        for(int i = 0; i < k; i++) xor = xor ^ arr[i];

        max = xor;
        for(int i = k; i < n; i++){
            xor ^= (arr[i-k] ^ arr[i]);
            max = Math.max(max, xor);
        }
        return max;
    }
}
