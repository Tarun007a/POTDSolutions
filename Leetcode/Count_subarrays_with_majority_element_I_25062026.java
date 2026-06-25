package Leetcode;

p// leetcode - 3737
// tc - O(n*n), sc - O(1)
class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        int result = 0;

        for(int i = 0; i < n; i++) {
            int freq = 0;

            for(int j = i; j < n; j++) {
                if(nums[j] == target) freq++;

                if(freq > (j-i+1)/2) result++;
            }
        }
        return result;
    }
}