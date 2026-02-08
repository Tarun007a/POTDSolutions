package Leetcodecontest.weekly488;

class Solution {
    public int dominantIndices(int[] nums) {
        int n = nums.length;
        int count = 0;

        for(int i = 0; i < n-1; i++){
            double sum = 0;
            for(int j = i+1; j < n; j++) sum += nums[j];

            if((double) nums[i] > sum/(n-i-1)) count++;
        }
        return count;
    }
}