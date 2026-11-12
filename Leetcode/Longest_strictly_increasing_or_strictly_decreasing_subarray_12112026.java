package Leetcode;

// leetcode - 3105
// tc - O(n), sc - O(1)
class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int currInc = 1;
        int currDec = 1;
        int max = 1;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] > nums[i]){
                currInc++;
                currDec = 1;
            }
            else if (nums[i + 1] < nums[i]){
                currInc = 1;
                currDec++;
            }
            else {
                currInc = 1;
                currDec = 1;
            }
            max = Math.max(max, Math.max(currInc, currDec));
        }
        return max;
    }
}
