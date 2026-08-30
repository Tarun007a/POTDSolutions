package Leetcode;

// leetcode - 2091
// tc - O(n), sc - O(1)
class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        if(n <= 2) return n;

        int minIdx = 0;
        int maxIdx = 0;

        for(int i = 0; i < n; i++) {
            if(nums[i] < nums[minIdx]) minIdx = i;
            if(nums[i] > nums[maxIdx]) maxIdx = i;
        }

        int left = Math.min(minIdx, maxIdx);
        int right = Math.max(minIdx, maxIdx);

        int result = Math.min(right + 1, n-left);
        result = Math.min(result, left + 1 + n - right);

        return result;
    }
}

