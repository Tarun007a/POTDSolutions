package Leetcode;

// leetcode - 1541
// tc - O(n), sc - O(1)
class Solution {
    public int minInsertions(String s) {
        int n = s.length();
        int result = 0;
        int open = 0;

        for(int i = 0; i < n; i++) {
            if(s.charAt(i) == '(') open++;
            else {
                open--;
                if(open < 0) {
                    open = 0;
                    result++;
                }
                if(i+1 < n && s.charAt(i+1) == ')') i++;
                else result++;
            }
        }
        return result + open * 2;
    }
}