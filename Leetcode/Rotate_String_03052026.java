package Leetcode;

// leetcode - 796
// tc - O(n), sc - O(n)
class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length() != goal.length()) return false;

        s = s + s;
        return s.contains(goal);
    }
}
