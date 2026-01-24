package Leetcode;

// leetcode - 1877
// tc - O(nlogn), sc - O(1)
class Solution {
    public int minPairSum(int[] nums) {
        int i = 0;
        int j = nums.length-1;
        Arrays.sort(nums);
        int result = nums[0] + nums[j];

        while(i < j){
            result = Math.max(result, nums[i++] + nums[j--]);
        }
        return result;
    }
}