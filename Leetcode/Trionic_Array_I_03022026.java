package Leetcode;

// tc - O(n*n), sc - O(1)
class Solution {
    private boolean check(int[] nums, int p, int q){
        for(int i = 1; i <= p; i++) if(nums[i-1] >= nums[i]) return false;
        for(int i = p+1; i <= q; i++) if(nums[i-1] <= nums[i]) return false;
        for(int i = q+1; i < nums.length; i++) if(nums[i-1] >= nums[i]) return false;
        return true;
    }
    public boolean isTrionic(int[] nums) {
        int n = nums.length;
        for(int i = 1; i < n-2; i++){
            for(int j = i+1; j < n-1; j++){
                if(check(nums, i, j)) return true;
            }
        }
        return false;
    }
}