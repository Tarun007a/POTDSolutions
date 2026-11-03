package Leetcode;

// leetcode - 3736
// tc - O(n), sc - O(1)
class Solution {
    public int minMoves(int[] nums) {
        int n = nums.length;
        int max = nums[0];
        int sum = 0;

        for(int i : nums) {
            max = Math.max(max, i);
            sum += i;
        }

        return n*max - sum ;
    }
}