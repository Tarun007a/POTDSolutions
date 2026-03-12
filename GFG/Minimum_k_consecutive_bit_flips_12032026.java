package GFG;

// tc & sc - O(n)
class Solution {
    public int kBitFlips(int[] arr, int k) {
        int n = arr.length;
        int[] remove = new int[n];
        int curr = 0;
        int result = 0;

        for(int i = 0; i < n; i++) {
            curr -= remove[i];

            if ((curr + arr[i]) % 2 == 0) {
                if (i > n-k) return -1;
                else {
                    curr++;
                    result++;
                    if(i+k < n) remove[i+k]++;
                }
            }
        }
        return result;
    }
}
