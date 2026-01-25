package Leetcode;

// leetcode - 1984
// tc - O(nlogn), sc - O(1)
class Solution {
    public int minimumDifference(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int result = Integer.MAX_VALUE;

        int st = 0;
        for(int end = k-1; end < n; end++){
            result = Math.min(result, nums[end] - nums[st++]);
        }
        return result;
    }
}
