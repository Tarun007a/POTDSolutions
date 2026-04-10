package Leetcode;

// leetcode - 3740
// tc - O(n^3), sc - O(1)
class Solution {
    public int minimumDistance(int[] nums) {
        int n = nums.length;
        int result = 100000;

        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                for(int k = j+1; k < n; k++){
                    if(nums[i] == nums[j] && nums[j] == nums[k]){
                        result = Math.min(result, (j-i) + (k-j) + (k-i));
                    }
                }
            }
        }
        return result == 100000 ? -1 : result;
    }
}