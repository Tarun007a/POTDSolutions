package Leetcodecontest.weekly486;

class Solution {
    public int minimumPrefixLength(int[] nums) {
        int idx = nums.length-2;

        while(idx >= 0 && nums[idx] < nums[idx+1]) idx--;
        return idx+1;
    }
}