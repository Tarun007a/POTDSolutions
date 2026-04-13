package Leetcode;

// leetcode - 1848
// tc - O(n), sc - O(1)
class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
        int result = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                result = Math.min(result, Math.abs(i - start));
            }
        }
        return result;
    }
}