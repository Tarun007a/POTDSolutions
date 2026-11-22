package Leetcodecontest.weekly529;

class Solution {
    public long minCost(int[] nums) {
        int n = nums.length;
        long result = Long.MAX_VALUE;
        int prev = 1;
        int i = 0;

        while(i < n-1) {
            int j = i;
            for(; j < n; j++) {
                if(nums[j] != nums[i]) break;
            }
            if(j != 1) result = Math.min(result, (long)(n - (j - i)) * nums[i]);
            i = j;
        }
        return result;
    }
}