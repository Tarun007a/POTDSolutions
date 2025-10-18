package Leetcode;

// leetcode - 3397
// tc - O(nlogn) sc - O(1)
class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int result = 1;
        int prev = nums[0]-k;

        for(int i = 1; i < n; i++){
            int curr = Math.max(nums[i]-k, prev+1);
            if(curr <= nums[i]+k){
                prev = curr;
                result++;
            }
        }
        return result;
    }
}
