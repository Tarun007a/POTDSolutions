package Leetcode;

// can be also done with binary seach on answer and also in O(n) time and O(1) space here it is
// leetcode - 3350
class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
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
            max = Math.max(max, Math.max(curr/2, Math.min(curr, prev)));
        }
        return max;
    }
}