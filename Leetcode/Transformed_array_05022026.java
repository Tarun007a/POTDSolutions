package Leetcode;

// leetcode - 3379
// tc- O(n), sc - O(n)
class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        for(int i = 0; i < n; i++){
            result[i] = nums[(n + i + (nums[i]%n))%n];
        }
        return result;
    }
}