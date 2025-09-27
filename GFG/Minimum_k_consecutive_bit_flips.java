package GFG;

// tc - O(n) and sc - O(n)
class Solution {
    public int kBitFlips(int[] arr, int k) {
        int n = arr.length;
        int result = 0;
        int currFlip = 0;
        int[] reduceFlip = new int[n];

        for(int i = 0; i < n; i++){
            if((arr[i] == 0 && currFlip%2 == 0) || (arr[i] == 1 && currFlip%2 == 1)){
                if(i >= n-k+1) return -1;
                currFlip++;
                result++;
                reduceFlip[i+k-1]++;
            }
            currFlip -= reduceFlip[i];
        }

        return result;
    }
}