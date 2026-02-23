package Leetcodecontest.weekly490;

// leetcode - 3847
class Solution {
    public int scoreDifference(int[] nums) {
        int player1 = 0;
        int player2 = 0;
        int n = nums.length;
        int swap = 6;
        boolean first = true;

        for(int i = 0; i < n; i++){
            swap--;
            if(swap == 0) {
                first = !first;
                swap = 6;
            }
            if(nums[i]%2 == 1) {
                first = !first;
            }

            if(first) player1 += nums[i];
            else player2 += nums[i];

        }
        return player1 - player2;
    }
}