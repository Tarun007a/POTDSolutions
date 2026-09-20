package Leetcode;

// leetcode - 3498
// tc - O(n), sc - O(1)
class Solution {
    public int reverseDegree(String s) {
        int result = 0;

        for(int i = 0; i < s.length(); i++) {
            int val = (26 - (s.charAt(i) - 'a')) * (i + 1);
            result += val;
        }
        return result;
    }
}