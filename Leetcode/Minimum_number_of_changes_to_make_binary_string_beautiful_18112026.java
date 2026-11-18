package Leetcode;

// leetcode - 2914
// tc - O(n), sc - O(1)
class Solution {
    public int minChanges(String s) {
        int n = s.length();
        int result = 0;

        for(int i = 1; i < n; i += 2) {
            if(s.charAt(i) != s.charAt(i-1)) result++;
        }
        return result;
    }
}