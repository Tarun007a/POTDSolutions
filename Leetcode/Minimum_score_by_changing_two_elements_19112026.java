package Leetcode;

// leetcode - 2567
// tc - O(nlogn), sc - O(1)
// as we are changing ele we will change any ele in such a way it is equal to any
// other ele so we can say low score in always 0, now we just minimize high score
class Solution {
    public int minimizeSum(int[] nums) {
        int n = nums.length;

        Arrays.sort(nums);

        return Math.min(nums[n-1] - nums[2],
                Math.min(nums[n-3] - nums[0], nums[n-2] - nums[1]));
    }
}