package Leetcode;

// leetcode - 3512
// tc - O(n), sc - O(1)
class Solution {
    public int minOperations(int[] nums, int k) {
        int sum = 0;
        for(int i : nums) sum += i;
        return sum%k;
    }
}
