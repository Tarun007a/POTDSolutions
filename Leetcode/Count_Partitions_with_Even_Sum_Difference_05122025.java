package Leetcode;

// leetcode - 3432
// tc - O(n), sc - O(1)
class Solution {
    public int countPartitions(int[] nums) {
        int n = nums.length;
        int result = 0;
        int total = 0;
        int curr = 0;

        for(int i : nums) total += i;

        for(int i = 0; i < n-1; i++){
            curr += nums[i];
            total -= nums[i];
            if((total-curr)%2 == 0) result++;
        }
        return result;
    }
}