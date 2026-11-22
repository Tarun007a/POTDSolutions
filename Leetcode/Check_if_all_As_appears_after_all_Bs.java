package Leetcode;

class Solution {
    public boolean checkString(String s) {
        boolean flag = false;

        for(char ch : s.toCharArray()) {
            if(ch == 'a') {
                if(flag) return false;
            }
            else {
                flag = true;
            }
        }
        return true;
    }
}