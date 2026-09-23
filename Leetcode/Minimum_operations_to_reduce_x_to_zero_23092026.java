package Leetcode;

// leetcode - 1658
// tc - O(n), sc - O(1)
class Solution {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        int st = 0;
        int max = -1;
        int curr = 0;
        int sum = 0;

        for(int num : nums) sum += num;

        int req = sum - x;

        for(int i = 0; i < n; i++) {
            curr += nums[i];

            while(curr > req) {
                if(st == n) return -1;
                curr -= nums[st++];
            }
            if(curr == req) {
                max = Math.max(max, i - st + 1);
            }
        }
        if(max == -1) return max;
        return n - max;
    }
}