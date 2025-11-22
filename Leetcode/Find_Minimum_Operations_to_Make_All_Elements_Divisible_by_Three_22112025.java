package Leetcode;

// leetcode - 3190
// tc - O(n), sc - O(1)
class Solution {
    public int minimumOperations(int[] nums) {
        int ans = 0;
        for(int i : nums){
            if(i%3 != 0)ans++;
        }
        return ans;
    }
}
