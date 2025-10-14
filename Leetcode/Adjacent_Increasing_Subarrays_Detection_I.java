package Leetcode;

// leetcode 3349
// tc - O(n) sc - O(1)
class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        if(k == 1) return true;
        int n = nums.size();
        int max = 1;
        int curr = 1;
        int prev = 1;

        for(int i = 1; i < n; i++){
            if(nums.get(i) > nums.get(i-1)) curr++;
            else{
                prev = curr;
                curr = 1;
            }
            if(curr/2 >= k || Math.min(curr, prev) >= k) return true;
        }
        return false;
    }
}