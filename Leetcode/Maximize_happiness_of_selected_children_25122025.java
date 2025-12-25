package Leetcode;

// leetcode - 3075
// tc - O(nlogn), sc - O(1)
class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        int n = happiness.length;
        Arrays.sort(happiness);
        long result = 0;
        int dec = 0;

        for(int i = n-1; i >= 0 && k > 0; i--){
            result += (long)Math.max(0, (happiness[i] - dec++));
            k--;
        }
        return result;
    }
}
