package GFG;

// tc - O(n * 32), sc - O(1)
class Solution {
    public long pairAndSum(int[] arr) {
        long result = 0;

        for(int i = 0; i < 32; i++) {
            long count = 0;
            for(int num : arr) {
                if(((1<<i) & num) != 0) count++;
            }

            long freq = (count * (count - 1)) / 2;
            result += (long)(1<<i) * freq;
        }
        return result;
    }
}