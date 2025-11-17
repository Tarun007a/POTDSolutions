package Leetcode;

// leetcode - 1437
// tc - O(n), sc - O(1)
class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int n = nums.length;
        int prev = -1;

        for(int i = 0; i < n; i++){
            if(nums[i] == 1){
                if(prev != -1 && i-prev <= k) return false;
                prev = i;
            }
        }
        return true;
    }
}
