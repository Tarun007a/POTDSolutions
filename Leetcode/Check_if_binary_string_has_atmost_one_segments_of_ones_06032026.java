package Leetcode;

// leetcode - 1784
// tc - O(n), sc - O(1)
class Solution {
    public boolean checkOnesSegment(String s) {
        boolean flag = false;
        boolean prev = false;

        for(char ch : s.toCharArray()) {
            if(ch == '1') {
                if(flag && !prev) return false;
                else if(!flag) {
                    flag = true;
                    prev = true;
                }
            }
            else prev = false;
        }
        return true;
    }
}