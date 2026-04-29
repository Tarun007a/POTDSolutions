package GFG;

// tc - O(n), sc - O(1)
class Solution {
    public int minSwaps(int[] arr) {
        int n = arr.length;
        int ones = 0;
        int curr = 0;

        for(int num : arr) ones += num == 1 ? 1 : 0;

        if(ones == 0) return -1;
        if(ones == n) return 0;

        for(int i = 0; i < ones; i++) {
            if(arr[i] == 1) curr++;
        }
        int min = ones - curr;

        for(int i = ones; i < n; i++) {
            if(arr[i-ones] == 1) curr--;
            if(arr[i] == 1) curr++;

            min = Math.min(min, ones-curr);
        }
        return min;
    }
}
