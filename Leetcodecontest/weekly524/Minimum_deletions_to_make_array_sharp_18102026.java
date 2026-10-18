package Leetcodecontest.weekly524;

class Solution {
    public int minDeletions(int[] nums) {
        int n = nums.length;
        int prev = 0;
        int count = 0;
        int result = 0;

        for(int i = 0; i < n; i++) {
            if(prev == nums[i]) result++;
            prev = nums[i];
        }
        return result;
    }
}