package Leetcode;

// leetcode - 396
// tc - O(n), sc - O(1)
class Solution {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        int curr = 0;
        int max = 0;
        int total = 0;

        for(int i = 0; i < n; i++) {
            curr += i * nums[i];
            total += nums[i];
        }
        max = curr;

        for(int i = n-1; i >= 0; i--) {
            curr -= nums[i] * (n-1);
            curr += total - nums[i];
            max = Math.max(max, curr);
        }
        return max;
    }
}