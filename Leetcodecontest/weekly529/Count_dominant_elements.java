package Leetcodecontest.weekly529;

class Solution {
    public int countDominantElements(int[] nums) {
        int result = 0;
        int n = nums.length;

        if(n == 1) return 1;

        for(int i = 0; i < n; i++) {
            if(i == 0) {
                if(nums[i] >= nums[i+1]) result++;
            }
            else if(i == n-1) {
                if(nums[i] >= nums[i-1]) result++;
            }
            else if(nums[i] >= (nums[i-1] + nums[i+1] + 1)/2) result++;
        }
        return result;
    }
}