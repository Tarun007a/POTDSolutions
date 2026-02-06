package Leetcode;

// leetcode - 3634
// tc - O(nlogn), sc - O(1)
class Solution {
    public int minRemoval(int[] nums, int k) {
        int n = nums.length;
        int result = n-1;
        Arrays.sort(nums);

        int lo = 0;

        for(int i = 1; i < n; i++){
            while((long)nums[lo]*k < (long)nums[i]) lo++;
            result = Math.min(result, n-(i-lo+1));
        }
        return result;
    }
}
