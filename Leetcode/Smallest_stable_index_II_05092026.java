package Leetcode;

// leetcode - 3904
// tc - O(n), sc - O(n)
class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;

        int min = nums[n-1];
        int max = nums[0];
        int[] smallest = new int[n];

        for(int i = n-1; i >= 0; i--) {
            min = Math.min(min, nums[i]);
            smallest[i] = min;
        }

        for(int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);
            if(max - smallest[i] <= k) return i;
        }
        return -1;
    }
}