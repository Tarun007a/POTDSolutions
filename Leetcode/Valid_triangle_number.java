package Leetcode;

// leetcode 611
// tc - O(n^2)

class Solution {
    public int triangleNumber(int[] nums) {
        int n = nums.length;
        int result = 0;
        Arrays.sort(nums);

        for(int i = n-1; i >= 2; i--){
            int st = 0;
            int end = i-1;
            while(st < end){
                if(nums[st]+nums[end] <= nums[i]) st++;
                else{
                    result += (end-st);
                    end--;
                }
            }
        }
        return result;
    }
}