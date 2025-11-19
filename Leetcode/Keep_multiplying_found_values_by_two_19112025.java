package Leetcode;

// leetcode - 2154
// tc - O(n), sc - O(n)
class Solution {
    public int findFinalValue(int[] nums, int original) {
        boolean[] isPresent = new boolean[2001];

        for(int i : nums) isPresent[i] = true;

        while(isPresent[original]) original *= 2;

        return original;
    }
}